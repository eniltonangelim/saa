package br.unifor.pin.saa.manager.aluno;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name = "atualizaAluno")
@Component(value = "atualizaAluno")

public class AtualizaAlunoManager {

	@Autowired
	private AlunosBO alunoBO;
	private Alunos alunosSelecionado;
	
	public String atualizar(){
		alunoBO.atualizar(alunosSelecionado);
		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Alunos alunos){
		alunosSelecionado = alunoBO.buscarPorId(alunos.getId());
		
		return Navigation.ATUALIZA;
	}
	
	public Alunos getAlunosSelecionado() {
		return alunosSelecionado;
	}
	
	public void setAlunosSelecionado(Alunos alunosSelecionado) {
		this.alunosSelecionado = alunosSelecionado;
	}
	
}
