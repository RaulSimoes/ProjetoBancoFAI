package fai.controle.web.command.impl;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fai.controle.impl.Fachada;
import fai.controle.web.command.ICommandFrontController;
import fai.controle.web.vh.LogarEntidadeContaBean;
import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;


public class CommandFrontControllerPagar<E> implements ICommandFrontController<EntidadeDominio> {
	//@ManagedProperty(value = "#{logarEntidadeContaBean}")
	private LogarEntidadeContaBean logarEntidadeContaBean; 
	
	private IFachada fachada;		
	
	
	@Override
	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, String aux) {				
		Resultado rs;
		//linha abaixo recupera sessao
		logarEntidadeContaBean = (LogarEntidadeContaBean) CommandFrontControllerPagar.getObjectSession("logarEntidadeContaBean");
		Conta conta = logarEntidadeContaBean.getConta();		
		rs = fachada.pagar(entidade, aux, conta);
		
		/*
		if (rs.getEntidades().size() > 0){
		Boleto boleto = (Boleto)rs.getEntidades().get(0); 	
			if (!boleto.getPago() ){					
				
				logarEntidadeContaBean = (LogarEntidadeContaBean) CommandFrontControllerPagar.getObjectSession("logarEntidadeContaBean");
				conta = logarEntidadeContaBean.getConta();
			    if (conta.getSaldo() >= boleto.getValor()){
			    	//Alterar boleto
			    	//debitar da conta
			    	//Salvar transação
			    }else{
			    	if ((conta.getSaldo()+conta.getLimite_credito() )>=
			    			boleto.getValor()){
				    	//Alterar boleto
				    	//debitar da conta
				    	//Salvarr transação			    		
			    	}
			    	else{
			    		//retorna mensagem informando que não foi possível
			    	}
			    }
			}
		}else{
			
		}*/
		return rs;
	}	
	
	public static <T> Object getObjectSession(String attribute){        
	    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
	    HttpSession session = request.getSession(true);    
	    return session.getAttribute(attribute);               
	} 	
	
	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public LogarEntidadeContaBean getLogarEntidadeContaBean() {
		return logarEntidadeContaBean;
	}

	public void setLogarEntidadeContaBean(
			LogarEntidadeContaBean logarEntidadeContaBean) {
		this.logarEntidadeContaBean = logarEntidadeContaBean;
	}
}
