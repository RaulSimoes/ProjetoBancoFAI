package fai.controle.web.vh;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.impl.ControllerJSF;
import fai.domain.Boleto;
import fai.domain.Resultado;

@ManagedBean
public class PagarEntidadeBoletoBean {
	private ControllerJSF controleJSF;
	private Boleto boleto;	
	private String numBoleto;
	
	public PagarEntidadeBoletoBean() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}	
	public String pagar() throws ServletException, IOException{
		boleto = new Boleto();
		boleto.setCodigo(numBoleto);
		controleJSF = new ControllerJSF();
		Resultado rs = controleJSF.processRequest(this.getClass().getName(), boleto);		
		return "FormTransacao";
	}

	public ControllerJSF getControleJSF() {
		return controleJSF;
	}

	public void setControleJSF(ControllerJSF controleJSF) {
		this.controleJSF = controleJSF;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public String getNumBoleto() {
		return numBoleto;
	}

	public void setNumBoleto(String numBoleto) {
		this.numBoleto = numBoleto;
	}
	
}
