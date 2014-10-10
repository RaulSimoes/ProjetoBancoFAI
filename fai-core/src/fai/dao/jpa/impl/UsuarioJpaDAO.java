
package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.Usuario;


public class UsuarioJpaDAO<U extends Usuario> extends AbstractJpaDAO<U> {
	
	@Override
	public List<U> consultar(U entidade) {
		Usuario u = (Usuario) entidade;
		if (u.getId()<=0 && u.getCpf() == null && u.getNome()== null && u.getSalario()== null && u.getTipo_cliente()== null){
			return consultarTodosUsuarios(entidade);
		}else{
			if(u.getId()!=0){
				return consultarUsuarioLogar(entidade);
			}else{
				return null;
			}
		}	
	}
	
	public List<U> consultarTodosUsuarios(U entidade) {
		List<U> usuarios=null;
		Query con = em.createQuery("SELECT u FROM Usuario u");
		
		usuarios= con.getResultList();
		return usuarios;		
	}
	
	public List<U> consultarUsuarioLogar(U entidade) {
		Usuario u = (Usuario) entidade;
		List<U> usuarios=null;
	//	Query con = em.createQuery("select u from Usuario u where"
	//			+ " u.senha = :senhaUsu and u.agencia = :agenciaUsu "
	//			+ "and u.conta = :contaUsu");
		Query con = em.createQuery("select u from Usuario u where"
		    	  + " u.id = :id_usu_fk");		
		con.setParameter("id_usu_fk", u.getId());
//		con.setParameter("agenciaUsu", u.getAgencia());		
//		con.setParameter("contaUsu", u.getConta());*/				
		//Query con = em.createQuery("select * from Usuario where u.agencia = '1'");
		usuarios= con.getResultList();
		return usuarios;
	}
	
	
	
}
