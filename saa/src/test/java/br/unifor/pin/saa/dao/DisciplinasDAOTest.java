package br.unifor.pin.saa.dao;

import java.util.List;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.entity.Perguntas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class DisciplinasDAOTest {
	
	@Autowired
	private DisciplinasDAO disciplinasDAO;
	
	@Autowired
	private PerguntasDAO perguntasDAO;
	
	private final String nome = "Lógica";
	private final String novoNome = "Lógica de Programação";
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Test
	public void testSalvar() throws Exception {
			
		Disciplinas disciplina = new Disciplinas();
		disciplina.setNome(this.nome);
		disciplina.setRegistro(this.timestamp);
		disciplinasDAO.salvar(disciplina);
		
		Assert.assertNotNull(disciplina.getId());
		System.out.println(disciplina.getId());
		disciplinasDAO.excluir(disciplina);
	}
	
	@Test
	public void testAtualizar() throws Exception {
		
		Disciplinas disciplina = new Disciplinas();
		disciplina.setNome(this.nome);
		disciplina.setRegistro(this.timestamp);
		disciplinasDAO.salvar(disciplina);
		disciplina.setNome(this.novoNome);
		disciplinasDAO.atualizar(disciplina);
		
		Assert.assertEquals(this.nome, disciplina.getNome());
		disciplinasDAO.excluir(disciplina);
		
	}
	
	@Test
	public void testListaPorNome() {
		Disciplinas disciplina = new Disciplinas();
		disciplina.setNome(this.nome);
		disciplina.setRegistro(this.timestamp);
		disciplinasDAO.salvar(disciplina);
		
		List<Disciplinas> disciplinas = disciplinasDAO.listarPorNome(this.nome);
		Assert.assertEquals(1, disciplinas.size());
		disciplinasDAO.excluir(disciplina);
	}
}
