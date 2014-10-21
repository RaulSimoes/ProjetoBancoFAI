package fai.controle.web.vh;


import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.command.ICommandFrontController;
import fai.controle.web.impl.ControllerJSF;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Usuario;

@ManagedBean
public class SalvarEntidadeUsuarioBean{
	
	private Usuario usuario;
	
	private String cpf;
	private String tipo_cliente;
	private Float salario;
	private String nome;
	
	private Conta conta;
	private String senha;
	private Float saldo;
	private Float limite_credito;
	private String agencia;
	private String num_conta;
	
	ControllerJSF controleJSF;
	
	public SalvarEntidadeUsuarioBean (){
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

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Float getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(Float limite_credito) {
		this.limite_credito = limite_credito;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
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
		controleJSF.processRequest(this.getClass().getName(), usuario);
		
		conta = new Conta();
		conta.setUsuario(usuario);
		conta.setSenha(senha);
		conta.setSaldo(saldo);
		conta.setLimite_credito(limite_credito);
		conta.setNum_conta(num_conta);
		conta.setAgencia(agencia);
		
		controleJSF.processRequest(this.getClass().getName(), conta);
		
		return (String) "FormMenuUsuario";
	}
}
