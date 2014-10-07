package fai.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="TB_Conta")
public class Conta extends EntidadeDominio implements Serializable{
	
	/**
	 * 
	 */
	@Column(length=6, nullable=false)	
	private String senha;
	private Float saldo;
	private Float limite_credito;
	@Column(length=6, nullable=false)	
	private String agencia;
	@Column(length=10, nullable=false)	
	private String num_conta;
	
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="usu_id")
	private Usuario usuario;
	
	@OneToMany (mappedBy="conta",
			cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Transacao> transacaos;	
	
	private static final long serialVersionUID = 1L;	
	
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
	public String getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}	
}
