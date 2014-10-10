package fai.controle.web.vh;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.command.impl.CommandFrontControllerConsultar;
import fai.controle.web.impl.ControllerJSF;
import fai.domain.Conta;
import fai.domain.Resultado;
import fai.domain.Usuario;

@ManagedBean
public class LogarEntidadeContaBean{
	private Conta conta;	
	private String agencia;
	private String num_conta;
	private String senha;
	private String erroLogin;
	private boolean mostrarBotao;
	ControllerJSF controleJSF;	
	
	public LogarEntidadeContaBean() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public String logar() throws ServletException, IOException{
		conta = new Conta();
		conta.setAgencia(agencia);
		conta.setNum_conta(num_conta);
		conta.setSenha(senha);
		
		controleJSF = new ControllerJSF();
		Resultado rs = controleJSF.processRequest(this.getClass().getName(), conta);		

		if(rs.getEntidades().size() > 0){
			ConsultarEntidadeUsuarioBean consultaUsuario = new ConsultarEntidadeUsuarioBean();
			Conta conta = (Conta) rs.getEntidades().get(0);
			rs = consultaUsuario.consultar(conta.getUsuario());
			Usuario usuario = (Usuario)rs.getEntidades().get(0);
			if(usuario.getTipo_cliente().equals("func")){
				setMostrarBotao(true);				
			}else{
				setMostrarBotao(false);			
			}			
			setAgencia("");
			setNum_conta("");
			setSenha("");
			setErroLogin("");	
			return (String)"FormMenuUsuario";			
		}else{					
			//retornar que houve erro	
			setAgencia("");
			setNum_conta("");
			setSenha("");
			setErroLogin("Erro no Login. Verifique se os dados digítados estam corretos!");			
			return (String)"FormLogin";			
		}		
		
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

	public String getErroLogin() {
		return erroLogin;
	}

	public void setErroLogin(String erroLogin) {
		this.erroLogin = erroLogin;
	}

	public boolean getMostrarBotao() {
		return mostrarBotao;
	}

	public void setMostrarBotao(boolean mostrarBotao) {
		this.mostrarBotao = mostrarBotao;
	}	
}
