package br.unifor.pin.saa.manager.professor;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadProfessor")
@Component(value = "cadProfessor")
public class CadProfessorManager implements Serializable {

	private static final long serialVersionUID = -126527714192790348L;

	@Autowired
	private ProfessoresBO professorBO;
	
	private String nome;
	private String mail;
	
	public String salvar(){
		Professores professor = new Professores();
		professor.setNome(nome);
		professor.setMail(mail);
		professor.setConfirmado(false);
		professor.setRegistro(new Timestamp(System.currentTimeMillis()));
		professorBO.salvar(professor);
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.mail = "";
	}

	public String getNome() {
		return nome;
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
	
}