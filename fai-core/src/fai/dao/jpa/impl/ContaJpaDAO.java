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
		em.close();
		return contas;		
	}
	
	private List<C> consultarPorID(C entidade) {
		Conta c = (Conta) entidade;
		List<C> contas=null;
		Query con = em.createQuery("select c from Conta c where"
				+ " c.id = :idConta");
		con.setParameter("idConta", c.getId());			
		//Query con = em.createQuery("select * from Usuario where u.agencia = '1'");
		contas= con.getResultList();
		return contas;		
	}
	
	@Override
	public void alterar(C entidade) {
		Conta c = (Conta) entidade;
		Query con= em.createQuery(
			      "UPDATE Conta c SET c.saldo = "+ Float.toString(c.getSaldo()) + 
			      " WHERE c.id = :idConta");
		//int updateCount = query.setParameter(p, 100000).executeUpdate();		
		//con.setParameter("saldoConta", c.getSaldo());	
		con.setParameter("idConta", c.getId()).executeUpdate();	
	}			
}
