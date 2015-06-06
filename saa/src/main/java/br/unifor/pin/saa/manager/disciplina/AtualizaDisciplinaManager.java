package br.unifor.pin.saa.manager.disciplina;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.DisciplinasBO;
import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name = "atualizaDisciplina")
@Component(value = "atualizaDisciplina")

public class AtualizaDisciplinaManager {

	@Autowired
	private DisciplinasBO disciplinasBO;
	private Disciplinas disciplinasSelecionado;
	
	public String atualizar(){
		disciplinasBO.atualizar(disciplinasSelecionado);
		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Disciplinas disciplinas){
		disciplinasSelecionado = disciplinasBO.buscarPorId(disciplinas.getId());
		
		return Navigation.ATUALIZA;
	}
	
	public Disciplinas getAlunosSelecionado() {
		return disciplinasSelecionado;
	}
	
	public void setAlunosSelecionado(Disciplinas disciplinasSelecionado) {
		this.disciplinasSelecionado = disciplinasSelecionado;
	}
	
}
