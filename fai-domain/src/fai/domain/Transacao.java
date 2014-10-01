package fai.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Transação
 *
 */
@Entity
@Table(name="TB_Transacao")
public class Transacao extends EntidadeDominio implements Serializable {

	
	private Float valor;
	@Column(length=10, nullable=false)	
	private String tipo_transacao;
	
	/*@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="conta_id")
	private Usuario conta;*/
	
	/*@OneToOne( fetch = FetchType.LAZY, 
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;*/

	private static final long serialVersionUID = 1L;

	public Transacao() {
		super();
	}   
	public Float getValor() {
		return this.valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}   

  
	public String getTipo_transacao() {
		return this.tipo_transacao;
	}

	public void setTipo_transacao(String tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}
   
}
