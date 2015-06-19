package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

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
@Table(name="alunos")
public class Alunos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -290262360117427420L;

	@Id
	@SequenceGenerator( name="alunos_id_seq", sequenceName="alunos_id_seq", allocationSize=1)
	@GeneratedValue( generator="alunos_id_seq",	strategy=GenerationType.SEQUENCE )
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Boolean confirmado;
	
	@Column(nullable=false)
	private String mail;
	
	@Column(nullable=false)
	private Boolean ativo;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;

	@Column(nullable=true, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp alterado;
	
	@ManyToMany(mappedBy="aluno")
	private Collection<Turmas> turma; 
	
	public Collection<Turmas> getTurma() {
		return turma;
	}

	public void setTurma(Collection<Turmas> turma) {
		this.turma = turma;
	}

	public Long getId() {
		return this.id;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean isConfirmado() {
		return this.confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getRegistro() {
		return this.registro;
	}

	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}

	public Timestamp getAlterado() {
		return alterado;
	}

	public void setAlterado(Timestamp alterado) {
		this.alterado = alterado;
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
		Alunos other = (Alunos) obj;
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