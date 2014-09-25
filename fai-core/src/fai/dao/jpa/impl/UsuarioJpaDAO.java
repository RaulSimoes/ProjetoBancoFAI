
package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.Usuario;


public class UsuarioJpaDAO<C extends Usuario> extends AbstractJpaDAO<C> {
	
	@Override
	public List<C> consultar(C entidade) {
		Usuario c = entidade;
		List<C> usuarios=null;
		if(c.getNome() == null){
			Query con = em.createQuery("select c from Usuario c where c.nome is empty");
				usuarios= con.getResultList();
		}
		return usuarios;
	}
}
