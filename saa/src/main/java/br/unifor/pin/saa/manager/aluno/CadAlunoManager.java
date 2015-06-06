package br.unifor.pin.saa.manager.aluno;



import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadAluno")
@Component(value="cadAluno")
public class CadAlunoManager {

	@Autowired
	private AlunosBO alunoBO;
	
	private String nome;
	private String mail;
	
	public String salvar(){
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setMail(mail);
		aluno.setAtivo(true);
		aluno.setConfirmado(false);
		aluno.setRegistro(new Timestamp(System.currentTimeMillis()));
		alunoBO.salvar(aluno);
		this.preparaSalvar();
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
	
	public String proximaTela(){
		return Navigation.PROXIMA;
	}
		
	public String anteriorTela(){
		return Navigation.ANTERIOR;
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
