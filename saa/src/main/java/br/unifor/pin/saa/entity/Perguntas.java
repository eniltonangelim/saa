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
@Table(name="perguntas")
public class Perguntas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1675343911489330181L;

	@Id
	@SequenceGenerator( name="perguntas_id_seq", sequenceName="perguntas_id_seq", allocationSize=1 )
	@GeneratedValue( generator="perguntas_id_seq", strategy=GenerationType.SEQUENCE )	
	private Long id;
	
	@Column
	private String pergunta;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;
	
	@Column 
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "turma_id", nullable = false)
	private Turmas turma;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public Timestamp getRegistro() {
		return registro;
	}
	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}
	public Boolean isAtivo() {
		return ativo;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Turmas getTurma() {
		return turma;
	}
	
	public void setTurma(Turmas turma) {
		this.turma = turma;
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
		Perguntas other = (Perguntas) obj;
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