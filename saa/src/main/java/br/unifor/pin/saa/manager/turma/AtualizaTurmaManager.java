package br.unifor.pin.saa.manager.turma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.bussines.DisciplinasBO;
import br.unifor.pin.saa.bussines.InstituicaoBO;
import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.bussines.TurmasBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.entity.Turmas;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaTurma")
@Component(value = "atualizaTurma")
public class AtualizaTurmaManager {

	@Autowired
	private TurmasBO turmasBO;
	@Autowired
	private ProfessoresBO professoresBO;
	@Autowired
	private InstituicaoBO instituicoesBO;
	@Autowired
	private AlunosBO alunosBO;
	@Autowired
	private DisciplinasBO disciplinasBO;
	private Turmas turmasSelecionado;
	
	public String atualizar(){
		turmasBO.atualizar(turmasSelecionado);
		
		return Navigation.SUCESSO;
	}
	
	public String preparaAtualizar(Turmas turma){
		turmasSelecionado = turmasBO.buscarPorId(turma.getId());
		return Navigation.ATUALIZA;
	}

	public Turmas getTurmasSelecionado() {
		return turmasSelecionado;
	}

	public void setTurmasSelecionado(Turmas turmaSelecionado) {
		this.turmasSelecionado = turmaSelecionado;
	}
	
}
