package br.unifor.pin.saa.manager.disciplina;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.DisciplinasBO;
import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "listDisciplina")
@Component(value = "listDisciplina")
public class ListDisciplinaManager {

	@Autowired
	private DisciplinasBO disciplinaBO;
	private String nome;
	private List<Disciplinas> disciplinas;
	
	public void lista(){
		setDisciplinas(disciplinaBO.ListarPorNome(nome));
	}
	
	public void excluir(Disciplinas aluno){
		disciplinaBO.excluir(aluno);
		setDisciplinas(disciplinaBO.ListarPorNome(nome));
	}
	
	public String preparaAtualizar(Disciplinas aluno){
		System.out.println(aluno.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.setDisciplinas(null);
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

	public List<Disciplinas> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplinas> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}