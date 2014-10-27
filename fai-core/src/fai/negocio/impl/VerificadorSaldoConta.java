	package fai.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.negocio.ICommand;

public class VerificadorSaldoConta implements ICommand{
	private IFachada fachada;
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, Object obj) {
		Resultado rs = fachada.consultar(entidade);				
		Conta c = (Conta) rs.getEntidades().get(0);		
		Boleto boleto = (Boleto) obj;
		
		if (!((c.getSaldo() >= boleto.getValor()) || 
			  ((c.getSaldo()+c.getLimite_credito() ) >= boleto.getValor()))
			){
			List<Mensagem> lista = new ArrayList<Mensagem>();
			lista.add(new Mensagem("Saldo insuficiente para pagar boleto."));
			rs.setMensagens(lista);			
		}			
		return rs;
	}
	public IFachada getFachada() {
		return fachada;
	}
	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

}
