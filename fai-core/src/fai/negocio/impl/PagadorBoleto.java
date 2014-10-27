package fai.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.negocio.ICommand;

public class PagadorBoleto implements ICommand {
	private IFachada fachada;
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, Object obj) {
		Resultado<EntidadeDominio> rs = new Resultado<EntidadeDominio>();
		Boleto boleto = (Boleto)entidade;
		boleto.setPago(true);
		fachada.alterar(boleto);	
		
		List<Mensagem> lista = new ArrayList<Mensagem>();
		lista.add(new Mensagem("Boleto pago com sucesso!"));
		rs.setMensagens(lista);									
		return rs;
	}
	public IFachada getFachada() {
		return fachada;
	}
	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
}
