package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.Boleto;

public class BoletoJpaDAO <B extends Boleto> extends AbstractJpaDAO<B> {
	@Override
	public List<B> consultar(B entidade) {
		Boleto b = (Boleto) entidade;
		List<B> boletos=null;
		Query con = em.createQuery("select b from Boleto b where"
		    	  + " b.codigo = :num_codigo");		
		con.setParameter("num_codigo", b.getCodigo());
		boletos= con.getResultList();
		return boletos;		
	}
}
