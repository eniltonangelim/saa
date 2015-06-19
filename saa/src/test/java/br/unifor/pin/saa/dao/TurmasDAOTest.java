package br.unifor.pin.saa.dao;


import org.junit.Assert;
import org.junit.Ignore;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.entity.Turmas;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class TurmasDAOTest {
	
	@Autowired
	private TurmasDAO turmasDAO;
	@Autowired
	private ProfessoresDAO professoresDAO;
	@Autowired
	private InstituicoesDAO instituicoesDAO;
	@Autowired
	private DisciplinasDAO disciplinasDAO;
	@Autowired 
	private AlunosDAO alunosDAO;
	
	private final String prof_nome = "Patrick";
	private final String inst_nome = "Universidade de Fortaleza";
	private final String aluno_nome = "Enilton Angelim";
	private final String disc_nome = "Lógica";
	private final String turma = "T010";
	private final String mail = "enilton@f13.com.br";
	
	
    @Ignore
	public void testSalvar() throws Exception {

		Professores professor = new Professores();
		professor.setNome(this.prof_nome);
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(this.inst_nome);
		
		Disciplinas disciplina = new Disciplinas();
		disciplina.setNome(this.disc_nome);
		
		Alunos aluno = new Alunos();
		aluno.setNome(this.aluno_nome);
		aluno.setMail(this.mail);

		Turmas turma = new Turmas();
		turma.setTurma(this.turma);
		turma.setProfessor(professor);
		turma.setInstituicao(instituicao);
		//turma.setDisciplina(disciplina);
		//turma.setAluno(aluno);
		turmasDAO.salvar(turma);

		
		Assert.assertNotNull(turma.getId());
		System.out.println(turma.getId());

	}

}
