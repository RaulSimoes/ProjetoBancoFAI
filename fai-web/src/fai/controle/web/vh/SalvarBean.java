package fai.controle.web.vh;


import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.command.ICommandFrontController;
import fai.controle.web.impl.ControllerJSF;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Usuario;

@ManagedBean
public class SalvarBean{
	
	private Usuario usuario;
	private String cpf;
	private String tipo_cliente;
	private Float salario;
	private String nome;
	ControllerJSF controleJSF;
	
	public SalvarBean (){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTipo_cliente() {
		return tipo_cliente;
	}
	
	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	
	public Float getSalario() {
		return salario;
	}
	
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String salvarUsuario() throws ServletException, IOException{
			
		System.out.println("CPF:" + cpf);
		System.out.println("Tipo:" + tipo_cliente);
		System.out.println("Salário:" + salario);
		System.out.println("Nome:" + nome);
		
		usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setSalario(Float.valueOf(salario));
		usuario.setTipo_cliente(tipo_cliente);
		
		controleJSF = new ControllerJSF();
		controleJSF.processRequest(this.getClass().getName(), usuario,"");
		
		return (String)"FormMenuUsuario";
	}
}
