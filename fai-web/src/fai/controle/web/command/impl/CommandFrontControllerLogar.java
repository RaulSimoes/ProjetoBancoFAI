package fai.controle.web.command.impl;

import fai.controle.web.command.ICommandFrontController;
import fai.core.controle.IFachada;
import fai.domain.EntidadeDominio;

public class CommandFrontControllerLogar<E> implements ICommandFrontController<EntidadeDominio> {
	private IFachada fachada;
	
	@Override
	public void execute(EntidadeDominio entidade) {
		fachada.consultar(entidade);
		
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
	
}
