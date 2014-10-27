
package fai.controle.web.command.impl;

import fai.controle.web.command.ICommandFrontController;
import fai.core.controle.IFachada;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;



public class CommandFrontControllerConsultar<E> implements ICommandFrontController<EntidadeDominio> {
	
	private IFachada fachada;
	
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, String aux) {
		return fachada.consultar(entidade);        					
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	
}
