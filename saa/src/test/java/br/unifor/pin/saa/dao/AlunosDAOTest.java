package br.unifor.pin.saa.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import br.unifor.pin.saa.entity.Alunos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
@TransactionConfiguration(defaultRollback=false)

public class AlunosDAOTest {
	
	@Autowired
	private AlunosDAO alunosDAO;
	
	private final String nome = "Enilton Angelim";
	private final Boolean is_confirmado = true;
	private final Boolean not_confirmado = false;
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private final String mail = "enilton@f13.com.br";

	@Test
	@Transactional
	public void testSalvar() throws Exception {
		
		Alunos aluno = new Alunos();
		aluno.setNome(this.nome);
		aluno.setConfirmado(this.not_confirmado);
		aluno.setMail(this.mail);
		aluno.setAtivo(this.not_confirmado);
		aluno.setRegistro(this.timestamp);
		alunosDAO.salvar(aluno);
		
		Assert.assertNotNull(alunosDAO.listarPorNome(this.nome));
		alunosDAO.excluir((Alunos) alunosDAO.listarPorNome(this.nome));
	}
	
	@Test
	public void testAtualizar() throws Exception {

		Alunos aluno = new Alunos();
		aluno.setNome(this.nome);
		aluno.setConfirmado(this.not_confirmado);
		aluno.setMail(this.mail);
		aluno.setAtivo(this.not_confirmado);
		aluno.setRegistro(this.timestamp);
		alunosDAO.salvar(aluno);
		aluno.setAtivo(this.is_confirmado);
		alunosDAO.atualizar(aluno);
		
		Assert.assertFalse(aluno.isConfirmado());
		System.out.println("UPDATE::O Aluno está ativo::id:"+aluno.getId());
		alunosDAO.excluir(aluno);
	}
	
		
	@Test
	public void testListaPorNome(){
		
		Alunos aluno = new Alunos();
		aluno.setNome(this.nome);
		aluno.setConfirmado(this.not_confirmado);
		aluno.setMail(this.mail);
		aluno.setAtivo(this.not_confirmado);
		aluno.setRegistro(this.timestamp);
		alunosDAO.salvar(aluno);
		
		List<Alunos> alunos = alunosDAO.listarPorNome("eni");
		Assert.assertEquals(1, alunos.size());
		alunosDAO.excluir(aluno);
	}

}
