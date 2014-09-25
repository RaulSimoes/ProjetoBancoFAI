package fai.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="TB_Usuario")
public class Usuario extends EntidadeDominio implements Serializable {

	
	private String nome;
	private String conta;
	private String cpf;
	private String senha;
	private Float saldo;
	private Float salario;
	private Float limite_credito;
	private String agencia;
	private String tipo_cliente;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public Float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}   
	public Float getSalario() {
		return this.salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}   
	public Float getLimite_credito() {
		return this.limite_credito;
	}

	public void setLimite_credito(Float limite_credito) {
		this.limite_credito = limite_credito;
	}   
	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}   
	public String getTipo_cliente() {
		return this.tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
   
}
