package fai.controle.web.vh;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import fai.controle.web.impl.ControllerJSF;
import fai.domain.Boleto;

@ManagedBean
public class SalvarEntidadeBoletoBean {
	private Boleto boleto;
	private ControllerJSF controleJSF;	
	private String codigo;
	private Float valor;
	private boolean pago;
	
	public String salvarBoleto() throws ServletException, IOException{
		
		boleto = new Boleto();
		boleto.setCodigo(codigo);
		boleto.setValor(Float.valueOf(valor));
		boleto.setPago(false);
		//boleto.setPago(Boolean.valueOf(pago));		
		
		controleJSF = new ControllerJSF();
		controleJSF.processRequest(this.getClass().getName(), boleto, "");
		
		return (String) "FormConsultarUsuario";
	}	
	
	//get and set
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
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
	
	
}
