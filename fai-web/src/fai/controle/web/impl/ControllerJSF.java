package fai.controle.web.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.command.ICommandFrontController;
import fai.controle.web.vh.FactoryMethodVH;
import fai.controle.web.vh.IViewHelperWeb;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;

public class ControllerJSF {
	@Autowired
	private Map<String, ICommandFrontController> commandsFC;
	
	public ControllerJSF() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public Resultado processRequest(String comando, EntidadeDominio entidadeDominio)
			throws ServletException, IOException {
		Resultado<EntidadeDominio> resultado;		
		//comando = "fai.controle.web.vh." + "LogarEntidadeContaBean";
		
		comando = comando.replaceAll("fai.controle.web.vh.", "");
		comando = comando.replaceAll("Bean", "");		
		String array[] = new String[2];  		  		
		array = comando.split("Entidade");

		EntidadeDominio entidade = entidadeDominio;
		ICommandFrontController<EntidadeDominio> cfc = getCommand(array[0]);				
		//ICommandFrontController<EntidadeDominio> cfc = getCommand(comando);
		
		resultado = cfc.execute(entidade);	
		return resultado;
	}	
	
	private ICommandFrontController<EntidadeDominio> getCommand(String command){
		
		return commandsFC.get("commandFrontController"+command);
		
	}

	public void setCommandsFC(Map<String, ICommandFrontController> commandsFC) {
		this.commandsFC = commandsFC;
	}	
}
