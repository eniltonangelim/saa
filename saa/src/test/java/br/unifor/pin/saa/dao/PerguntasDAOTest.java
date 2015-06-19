package br.unifor.pin.saa.dao;

import java.util.List;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Perguntas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class PerguntasDAOTest {
	
	@Autowired
	private PerguntasDAO perguntasDAO;
	
	private final String pergunta = "Responda: 9 + 5 = 414?";
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private final Boolean ativo = true;
	private final Boolean inativo = false;
	
	@Test
	public void testSalvar() throws Exception {
		
		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);
		pergunta.setAtivo(this.inativo);
		perguntasDAO.salvar(pergunta);
		
		Assert.assertNotNull(pergunta.getId());
		System.out.println(pergunta.getId());
		perguntasDAO.excluir(pergunta);
	}
	
	@Ignore
	public void testAtualizar() throws Exception {

		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);
		pergunta.setAtivo(this.inativo);
		perguntasDAO.salvar(pergunta);
		pergunta.setAtivo(this.ativo);
		perguntasDAO.atualizar(pergunta);
		
		Assert.assertFalse(pergunta.isAtivo());
		System.out.println("UPDATE::Atualizado pergunta::id:"+pergunta.getId());
		perguntasDAO.excluir(pergunta);
	}
	
	@Test
	public void testListaPorNome(){
		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);
		pergunta.setAtivo(this.inativo);
		perguntasDAO.salvar(pergunta);
		
		List<Perguntas> alunos = perguntasDAO.listarPorNome(this.pergunta);
		Assert.assertEquals(1, alunos.size());
		perguntasDAO.excluir(pergunta);
	}

}
