package fai.dao.jpa.impl;

import java.util.List;

import fai.domain.EntidadeDominio;
import fai.domain.Transacao;

public class TransacaoJpaDAO <T extends Transacao> extends AbstractJpaDAO<T>{

	public List<T> pagar(EntidadeDominio entidade, String num_boleto){
		return null;
	}

	@Override
	public List<T> consultar(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}
}