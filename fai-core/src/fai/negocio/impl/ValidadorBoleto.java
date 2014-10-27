package fai.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import fai.controle.impl.Fachada;
import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.negocio.ICommand;

public class ValidadorBoleto<E extends EntidadeDominio> implements ICommand{
	private IFachada fachada;
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, Object obj) {
		Resultado rs = fachada.consultar(entidade);
		Boleto boleto;		
		if (rs.getEntidades().size() > 0){
			    boleto = (Boleto)rs.getEntidades().get(0); 			    
				if (boleto.getPago() ){
					List<Mensagem> lista = new ArrayList<Mensagem>();
					lista.add(new Mensagem("Não é posssível pagar novamente. Boleto já havia sido pago."));
					rs.setMensagens(lista);				
				}else{
					rs.getEntidades().add(boleto);					
				}				
			}else{
				List<Mensagem> lista = new ArrayList<Mensagem>();
				lista.add(new Mensagem("Código do boleto inválido"));
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
