package br.unifor.pin.saa.dao;

import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Perguntas;
import br.unifor.pin.saa.entity.Respostas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class RespostasDAOTest {
	
	@Autowired
	private RespostasDAO respostasDAO;
	@Autowired
	private PerguntasDAO perguntasDAO;
	@Autowired
	private AlunosDAO alunosDAO;
	
	private final String pergunta = "Responda: 9 + 5 = 414?";
	private final String resposta = "9 - 5 = 4; 9 + 5 = 14?";
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	

	@Test
	public void testSalvar() throws Exception {
		
		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);		
		perguntasDAO.salvar(pergunta);
		
		Respostas resposta = new Respostas();
		resposta.setResposta(this.resposta);
		resposta.setRegistro(this.timestamp);
		resposta.setNota(5);
		resposta.setPerguntas(pergunta);
		respostasDAO.salvar(resposta);
		
		Assert.assertNotNull(resposta.getId());
		System.out.println(resposta.getId());
		respostasDAO.excluir(resposta);

	}
	
	@Test
	public void testAtualiza() throws Exception {
		
		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);		
		perguntasDAO.salvar(pergunta);
		
		Respostas resposta = new Respostas();
		resposta.setResposta(this.resposta);
		resposta.setRegistro(this.timestamp);
		resposta.setNota(5);
		resposta.setPerguntas(pergunta);
		respostasDAO.salvar(resposta);
		resposta.setNota(7);
		respostasDAO.atualizar(resposta);
		
		Assert.assertEquals("5", resposta.getNota());
		System.out.println(resposta.getId());
		respostasDAO.excluir(resposta);

	}
	
	@Test
	public void testListaPorNome(){
		Perguntas pergunta = new Perguntas();
		pergunta.setPergunta(this.pergunta);
		pergunta.setRegistro(this.timestamp);		
		perguntasDAO.salvar(pergunta);
		
		Respostas resposta = new Respostas();
		resposta.setResposta(this.resposta);
		resposta.setRegistro(this.timestamp);
		resposta.setNota(5);
		resposta.setPerguntas(pergunta);
		respostasDAO.salvar(resposta);
		
		
		List<Respostas> respostas = respostasDAO.listarPorNome(this.resposta);
		Assert.assertEquals(1, respostas.size());
		respostasDAO.excluir(resposta);
	}
}
