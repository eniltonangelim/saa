package br.unifor.pin.saa.manager.turma;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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


@SessionScoped
@ManagedBean(name = "cadTurma")
@Component(value = "cadTurma")
public class CadTurmaManager {

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
	
	private Turmas turma;
	
	public CadTurmaManager() {
		 this.turma = new Turmas();
	}
	
	public String salvar() throws Exception{
		
		turma.setRegistro(new Timestamp(System.currentTimeMillis()));
		turmasBO.salvar(this.turma);
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
	
	public void limpaDados(){
		this.turma.setTurma(null);
	}	
	
	public Turmas getTurma() {
		return turma;
	}

	public void setTurma(Turmas turma) {
		this.turma = turma;
	}

	public Collection<SelectItem> getProfessores() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "Selecione"));
		List<Professores> professores = professoresBO.buscarTodos();
		for (Professores professor : professores) {
			MessagesUtils.info("Turma as Professor: " + professor.getNome());
			items.add(new SelectItem(professor, professor.getNome()));
		}
		return items;
	}

	public Collection<SelectItem> getInstituicoes() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "Selecione"));
		List<Instituicoes> instituicoes = instituicoesBO.buscarTodos();
		for (Instituicoes instituicao : instituicoes) {
			items.add(new SelectItem(instituicao, instituicao.getNome()));
		}
		return items;
	}
	
	public Collection<SelectItem> getAlunos() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		List<Alunos> alunos = alunosBO.buscarTodos();
		for (Alunos aluno : alunos) {
			items.add(new SelectItem(aluno, aluno.getNome()));
		}
		return items;
	}

	public Collection<SelectItem> getDisciplinas() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "Selecione"));
		List<Disciplinas> disciplinas = disciplinasBO.buscarTodos();
		for (Disciplinas disciplina : disciplinas) {
			items.add(new SelectItem(disciplina, disciplina.getNome()));
		}
		return items;
	}
		
}
