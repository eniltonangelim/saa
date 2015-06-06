package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="token")
public class Token implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4984841883432587134L;

	@Id
	@SequenceGenerator( name="token_id_seq", sequenceName="token_id_seq", allocationSize=1 )
	@GeneratedValue( generator="token_id_seq", strategy=GenerationType.SEQUENCE )
	private Long id;

	@Column(nullable=false)
	private String hash;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp validade;
	
	@Column(nullable=false)
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuarios usuario;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Timestamp getValidade() {
		return validade;
	}

	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;	
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	//GenerateToken
}
