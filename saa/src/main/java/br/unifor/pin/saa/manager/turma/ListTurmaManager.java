package br.unifor.pin.saa.manager.turma;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.TurmasBO;
import br.unifor.pin.saa.entity.Turmas;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name = "listTurma")
@Component(value = "listTurma")
public class ListTurmaManager {
	
	@Autowired
	private TurmasBO turmasBO;
	private String turma;
	private List<Turmas> turmas;
	
	public void lista(){
		turmas = turmasBO.listarPorNome(turma);
	}
	
	public void excluir(Turmas turma2){
		turmasBO.excluir(turma2);
		turmas = turmasBO.listarPorNome(turma);
	}
	
	public String preparaAtualizar(Turmas turma2){
		System.out.println(turma2.getTurma());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.turma = "";
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public List<Turmas> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turmas> turmas) {
		this.turmas = turmas;
	}
		
}
