package fai.controle.web.vh;

import java.io.IOException;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.impl.Fachada;
import fai.controle.web.impl.ControllerJSF;
import fai.core.controle.IFachada;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.domain.Transacao;

@ManagedBean
public class PagarEntidadeBoletoBean {
	private Boleto boleto;	
	private String numBoleto;
	private String feedBackPagarBoleto; 
	ControllerJSF controleJSF;		
	
	public String pagar() throws ServletException, IOException{
		boleto = new Boleto();	
		controleJSF = new ControllerJSF();
		Resultado rs = controleJSF.processRequest(this.getClass().getName(), boleto,numBoleto);	
		if (rs != null){
			if(rs.getMensagens()!=null){
				if (rs.getMensagens().size() > 0 ){
					Mensagem msg = (Mensagem) rs.getMensagens().get(0);
					setFeedBackPagarBoleto(msg.toString());							
				}
			}
		}
		return "FormTransacao";
	}

	/*public ControllerJSF getControleJSF() {
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
	}*/

	public String getNumBoleto() {
		return numBoleto;
	}

	public void setNumBoleto(String numBoleto) {
		this.numBoleto = numBoleto;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public ControllerJSF getControleJSF() {
		return controleJSF;
	}

	public void setControleJSF(ControllerJSF controleJSF) {
		this.controleJSF = controleJSF;
	}

	public String getFeedBackPagarBoleto() {
		return feedBackPagarBoleto;
	}

	public void setFeedBackPagarBoleto(String feedBackPagarBoleto) {
		this.feedBackPagarBoleto = feedBackPagarBoleto;
	}
	
}
