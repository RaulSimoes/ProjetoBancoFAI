package fai.negocio.impl;

import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.negocio.ICommand;

public class DebitadorConta implements ICommand {
	private IFachada fachada;
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, Object obj) {
		Resultado rs = fachada.consultar(entidade);				
		Conta c = (Conta) rs.getEntidades().get(0);		
		Boleto boleto = (Boleto) obj;
		c.setSaldo(c.getSaldo() - boleto.getValor());
		fachada.alterar(c);
		return rs;
	}

	public IFachada getFachada() {
		return fachada;
	}
	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}	
	
}
