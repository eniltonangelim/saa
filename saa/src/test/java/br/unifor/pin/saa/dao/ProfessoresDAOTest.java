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
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Professores;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class ProfessoresDAOTest {
	
	@Autowired
	private ProfessoresDAO professoresDAO;
	
	private final String nome = "Enilton";
	private final Boolean is_confirmado = true;
	private final Boolean not_confirmado = false;
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private final String mail = "enilton@f13.com.br";

	@Test
	@Transactional
	public void testSalvar() throws Exception {
		
		Professores professor = new Professores();
		professor.setNome(this.nome);
		professor.setConfirmado(this.not_confirmado);
		professor.setMail(this.mail);
		professor.setRegistro(this.timestamp);
		professoresDAO.salvar(professor);
		
		Assert.assertNotNull(professoresDAO.listarPorNome(this.nome));
		System.out.println(professor.getId());
		professoresDAO.excluir(professor);
	}
	
	@Test
	public void testAtualizar() throws Exception {

		Professores professor = new Professores();
		professor.setNome(this.nome);
		professor.setConfirmado(this.not_confirmado);
		professor.setMail(this.mail);
		professor.setRegistro(this.timestamp);
		professoresDAO.salvar(professor);

		professor.setConfirmado(this.is_confirmado);
		professoresDAO.atualizar(professor);
		
		Assert.assertFalse(professor.isConfirmado());
		System.out.println("UPDATE::Atualizado professor::id:"+professor.getId());
		professoresDAO.excluir(professor);
	}
	
	@Test
	public void testListaPorNome(){
		List<Professores> professores = professoresDAO.listarPorNome("Eni");
		Assert.assertEquals(1, professores.size());
	}

}
