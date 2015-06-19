package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="turmas")
public class Turmas implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 6805444668212533325L;

	@Id
	@SequenceGenerator( name="turmas_id_seq", sequenceName="turmas_id_seq", allocationSize=1)
	@GeneratedValue( generator="turmas_id_seq",	strategy=GenerationType.SEQUENCE )
	private Long id;

	@Column(nullable = false)
	private String turma;
	
	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Professores professor;
	
	@ManyToOne
	@JoinColumn(name = "instituicao_id", nullable = false)
	private Instituicoes instituicao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "turma_has_aluno",
	    joinColumns = { 
	        @JoinColumn(name = "turma_id", referencedColumnName = "id")
		}, 
		inverseJoinColumns = { 
	        @JoinColumn(name = "aluno_id", referencedColumnName = "id")
		}
	)
	private Collection<Alunos> aluno;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_id", nullable = false)
	private Disciplinas disciplina;

	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;
	
	public Turmas() {
		aluno = new ArrayList<Alunos>();
	}

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

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Professores getProfessor() {
		return professor;
	}

	public void setProfessor(Professores professor) {
		this.professor = professor;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}


	public Collection<Alunos> getAluno() {
		return aluno;
	}

	public void setAluno(Collection<Alunos> aluno) {
		this.aluno = aluno;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
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
		Turmas other = (Turmas) obj;
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
