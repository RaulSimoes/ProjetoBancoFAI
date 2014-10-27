package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fai.domain.Boleto;
import fai.domain.Conta;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
	
	@Override
	public void alterar(B entidade) {
		Boleto b = (Boleto) entidade;
		Query con= em.createQuery(
			      "UPDATE Boleto b SET b.pago = "+ Boolean.toString(b.getPago()) + 
			      " WHERE b.id = :idBoleto");
		//int updateCount = query.setParameter(p, 100000).executeUpdate();		
		//con.setParameter("saldoConta", c.getSaldo());	
		con.setParameter("idBoleto", b.getId()).executeUpdate();	
	}	
}
