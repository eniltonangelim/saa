package br.unifor.pin.saa.manager.professor;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;

@RequestScoped
@ManagedBean(name = "listProfessor")
@Component(value = "listProfessor")
public class ListProfessorManager {
	
	@Autowired
	private ProfessoresBO professorBO;
	private String nome;
	private List<Professores> professores;
	
	public void lista(){
		professores = professorBO.ListarPorNome(nome);
	}
	
	public void excluir(Professores professor){
		professorBO.excluir(professor);
		professores = professorBO.ListarPorNome(nome);
	}
	
	public String preparaAtualizar(Professores professor){
		System.out.println(professor.getNome());
		return null;
	}
	
	public void limparDados(){
		this.nome = "";
		this.professores = null;
	}
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professores> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professores> professores) {
		this.professores = professores;
	}
	
	
}
