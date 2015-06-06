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
@Table(name="professores")
public class Professores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9210418960789098116L;

	@Id
	@SequenceGenerator(	name="professores_id_seq", sequenceName="professores_id_seq", allocationSize=1)
	@GeneratedValue( generator="professores_id_seq", strategy=GenerationType.SEQUENCE )
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String mail;
	
	@Column
	private Boolean ativo;
	
	@Column 
	private Boolean confirmado;
	
	@Column(nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
	@Type(type="timestamp")
	private Timestamp registro;
	
	@Column
	private String senha;
	
	public Long getId() {
		return this.id;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}


	public Boolean isConfirmado(){
		return this.confirmado;
	}
	
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Timestamp getRegistro() {
		return registro;
	}

	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		Professores other = (Professores) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
