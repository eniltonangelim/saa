package br.unifor.pin.saa.manager.professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaProfessor")
@Component(value = "atualizaProfessor")

public class AtualizaProfessorManager {

	@Autowired
	private ProfessoresBO professorBO;
	private Professores professorSelecionado;
	
	
	public String atualizar(){
		professorBO.atualizar(professorSelecionado);
		return Navigation.SUCESSO;
	}
	
	
	public String preparaAtualizar(Professores professor){
		professorSelecionado = professorBO.buscarPorId(professor.getId());
		return Navigation.ATUALIZA;
	}

	
	public Professores getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professores professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
	
	
}
