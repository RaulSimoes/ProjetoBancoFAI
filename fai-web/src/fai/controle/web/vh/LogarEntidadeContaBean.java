package fai.controle.web.vh;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.impl.ControllerJSF;
import fai.domain.Conta;

@ManagedBean
public class LogarEntidadeContaBean{
	private Conta conta;	
	private String agencia;
	private String num_conta;
	private String senha;
	ControllerJSF controleJSF;	
	
	public LogarEntidadeContaBean() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public String logar() throws ServletException, IOException{
		
		System.out.println("Agencia:" + agencia);
		System.out.println("Número da conta:" + num_conta);
		System.out.println("Senha:" + senha);
		
		conta = new Conta();
		conta.setAgencia(agencia);
		conta.setNum_conta(num_conta);
		conta.setSenha(senha);
		
		controleJSF = new ControllerJSF();
		controleJSF.processRequest(this.getClass().getName(), conta);
		
		return (String)"FormMenuUsuario";		
	}
	
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ControllerJSF getControleJSF() {
		return controleJSF;
	}

	public void setControleJSF(ControllerJSF controleJSF) {
		this.controleJSF = controleJSF;
	}	
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}	
}
