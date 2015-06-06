package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy="pergunta")
	private List<Disciplinas> disciplina;

	public Perguntas(){
		disciplina = new ArrayList<Disciplinas>();
	}
	
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

	public List<Disciplinas> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplinas> disciplina) {
		this.disciplina = disciplina;
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