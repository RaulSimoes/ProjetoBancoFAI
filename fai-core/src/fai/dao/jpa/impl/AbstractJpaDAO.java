package fai.dao.jpa.impl;


import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.springframework.transaction.annotation.Transactional;

import fai.dao.IDAO;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;


public abstract class AbstractJpaDAO<E extends EntidadeDominio> implements IDAO<E> {
	protected EntityManagerFactory emf;
	@PersistenceContext 
	protected EntityManager em;
	protected EntidadeDominio entidadeDominio;		
	
	//@Transactional para o spring
	@Transactional
	public void salvar(E entidade) {
		/*em.getTransaction().begin();		
		em.persist(entidade);			
		em.getTransaction().commit();	*/
		
		//Quando configurado pelo spring
		em.persist(entidade);
	}	
	@Override
	public void alterar(E entidade) {
		em.refresh(entidade);
		//em.getTransaction().commit();	
		//entidadeDominio = em.merge(entidade);
		//em.refresh(entidadeDominio);
	}
	@Override
	public void excluir(E entidade) {
		entidade = (E) em.find(entidade.getClass(), entidade.getId());
        if (entidade != null) {
        	em.getTransaction().begin();
        	em.remove(entidade);
        	em.getTransaction().commit();
        }
	}
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}	
	
	
}
