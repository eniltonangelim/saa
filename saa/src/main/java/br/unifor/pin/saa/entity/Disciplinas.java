package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy="disciplina")
	private Collection<Turmas> turma;
	
	@ManyToMany
	@JoinTable(name = "disciplina_has_perguntas")
	private Collection<Perguntas> pergunta;
	
	public Disciplinas(){
		turma = new ArrayList<Turmas>();
		pergunta = new ArrayList<Perguntas>();
	}

	public Collection<Perguntas> getPergunta() {
		return pergunta;
	}

	public void setPergunta(Collection<Perguntas> pergunta) {
		this.pergunta = pergunta;
	}


	public Collection<Turmas> getTurma() {
		return turma;
	}

	public void setTurma(Collection<Turmas> turma) {
		this.turma = turma;
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