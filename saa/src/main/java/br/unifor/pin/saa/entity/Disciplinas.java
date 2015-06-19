package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="disciplinas")
public class Disciplinas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635822324924017079L;

	@Id
	@SequenceGenerator( name="disciplinas_id_seq", sequenceName="disciplinas_id_seq", allocationSize=1 )
	@GeneratedValue( generator="disciplinas_id_seq", strategy=GenerationType.SEQUENCE )
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;

	public Timestamp getRegistro() {
		return registro;
	}

	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Disciplinas other = (Disciplinas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	 public String toString() {
	     return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	 }
	
}