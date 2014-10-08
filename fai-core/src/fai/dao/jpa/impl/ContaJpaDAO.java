package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.Conta;

public class ContaJpaDAO <C extends Conta> extends AbstractJpaDAO<C> {
	@Override
	public List<C> consultar(C entidade) {
		Conta c = (Conta) entidade;
		if (c.getAgencia().isEmpty() && c.getNum_conta().isEmpty() && c.getSenha().isEmpty()){
			return 	null;
		}else{
			return 	consultarLogin(entidade);
		}		
	}
	
	private List<C> consultarLogin(C entidade) {
		Conta c = (Conta) entidade;
		List<C> contas=null;
		Query con = em.createQuery("select c from Conta c where"
				+ " c.senha = :senhaUsu and c.agencia = :agenciaUsu "
				+ "and c.num_conta = :contaUsu");
		con.setParameter("senhaUsu", c.getSenha());
		con.setParameter("agenciaUsu", c.getAgencia());		
		con.setParameter("contaUsu", c.getNum_conta());				
		//Query con = em.createQuery("select * from Usuario where u.agencia = '1'");
		contas= con.getResultList();
		return contas;		
	}
	
	
	
}
