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
@Table(name="respostas")
public class Respostas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8053824379778458924L;

	@Id
	@SequenceGenerator( name="respostas_id_seq", sequenceName="respostas_id_seq", allocationSize=1)
	@GeneratedValue( generator="respostas_id_seq",	strategy=GenerationType.SEQUENCE )
	private Long id;
	
	@Column(nullable=false)
	private String resposta;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;
	
	@Column(nullable=false)
	private Integer nota;
	
	@ManyToOne
	@JoinColumn(name="perguntas_id")
	private Perguntas perguntas;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Timestamp getRegistro() {
		return registro;
	}

	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Perguntas getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(Perguntas perguntas) {
		this.perguntas = perguntas;
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
		Respostas other = (Respostas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
