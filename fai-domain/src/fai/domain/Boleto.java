package fai.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Boleto
 *
 */
@Entity
@Table(name="TB_Boleto")
public class Boleto extends EntidadeDominio implements Serializable {
	@Column(length=50, nullable=false)
	private String codigo;
	
	@Column(length=12, nullable=false)	
	private Float valor;

	@Column(nullable=false)	
	private boolean pago;	
	
	/*@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="usu_id")
	private Usuario usuario;*/
	
	private static final long serialVersionUID = 1L;

	public Boleto() {
		super();
	}

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
		
	/*public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

	public boolean getPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
   
}
