package br.unifor.pin.saa.manager.turma;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.TurmasBO;
import br.unifor.pin.saa.entity.Turmas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaTurma")
@Component(value = "atualizaTurma")
public class AtualizaTurmaManager {

	@Autowired
	private TurmasBO turmasBO;
	private Turmas turmaSelecionado;
	
	public String atualizar(){
		turmasBO.atualizar(turmaSelecionado);
		
		return Navigation.SUCESSO;
	}
	
	public String preparaAtualizar(Turmas turma){
		turmaSelecionado = turmasBO.buscarPorId(turma.getId());
		return Navigation.ATUALIZA;
	}

	public Turmas getTurmaSelecionado() {
		return turmaSelecionado;
	}

	public void setTurmaSelecionado(Turmas turmaSelecionado) {
		this.turmaSelecionado = turmaSelecionado;
	}
	
}
