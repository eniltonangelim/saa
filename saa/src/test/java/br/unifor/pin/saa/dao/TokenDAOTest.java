package br.unifor.pin.saa.dao;


import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Ignore;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Token;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class TokenDAOTest {
	
	@Autowired
	private TokenDAO tokenDAO;
	
	@Autowired
	private AlunosDAO alunosDAO;
	
	private final String nome = "Enilton Angelim";
	private final Boolean not_confirmado = false;
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private final String mail = "enilton@f13.com.br";
    private final String hash_token = "idao,joihiusfzhoj2";
	
	
	@Ignore
	public void testSalvar() throws Exception {
			
		Alunos aluno = new Alunos();
		aluno.setNome(this.nome);
		aluno.setConfirmado(this.not_confirmado);
		aluno.setMail(this.mail);
		aluno.setAtivo(this.not_confirmado);
		aluno.setRegistro(this.timestamp);
		alunosDAO.salvar(aluno);
		
		Token token = new Token();
		token.setHash(this.hash_token);
		token.setValidade(this.timestamp);
		token.setEstado(true);
		//token.setAluno(aluno);
		tokenDAO.salvar(token);
		
		Assert.assertNotNull(token.getId());
		System.out.println(token.getId());

	}

}
