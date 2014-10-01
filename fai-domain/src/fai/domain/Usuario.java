package fai.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="TB_Usuario")
public class Usuario extends EntidadeDominio implements Serializable {

	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=12, nullable=false)	
	private String cpf;
	@Column(length=10, nullable=false)	
	private String tipo_cliente;
	private Float salario;	
	
	@OneToMany (mappedBy="usuario",
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Conta> contas;
	
	private static final long serialVersionUID = 1L;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

}
