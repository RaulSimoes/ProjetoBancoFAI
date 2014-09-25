package fai.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Log
 *
 */
@Entity
@Table(name="TB_Log")
public class Log extends EntidadeDominio implements Serializable {

	
	private Float valor;
	private String tipo_transacao;
	
	@OneToOne( fetch = FetchType.LAZY, 
			cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;	

	private static final long serialVersionUID = 1L;

	public Log() {
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
