
package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.EntidadeDominio;
import fai.domain.Usuario;


public class UsuarioJpaDAO<U extends Usuario> extends AbstractJpaDAO<U> {
	
	@Override
	public List<U> consultar(U entidade) {
		Usuario u = (Usuario) entidade;
		List<U> usuarios=null;
		Query con = em.createQuery("select u from Usuario u where"
				+ " u.senha = :senhaUsu and u.agencia = :agenciaUsu "
				+ "and u.conta = :contaUsu");
		con.setParameter("senhaUsu", u.getSenha());
		con.setParameter("agenciaUsu", u.getSenha());		
		con.setParameter("contaUsu", u.getSenha());				
		//Query con = em.createQuery("select * from Usuario where u.agencia = '1'");
		usuarios= con.getResultList();
		return usuarios;
	}
	
	public List<U> consultarUsuarioLogar(U entidade) {
		Usuario u = (Usuario) entidade;
		List<U> usuarios=null;
		Query con = em.createQuery("select u from Usuario u where"
				+ " u.senha = :senhaUsu and u.agencia = :agenciaUsu "
				+ "and u.conta = :contaUsu");
		con.setParameter("senhaUsu", u.getSenha());
		con.setParameter("agenciaUsu", u.getAgencia());		
		con.setParameter("contaUsu", u.getConta());				
		//Query con = em.createQuery("select * from Usuario where u.agencia = '1'");
		usuarios= con.getResultList();
		return usuarios;
	}
}
