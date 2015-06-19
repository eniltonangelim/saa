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

import br.unifor.pin.saa.entity.Instituicoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class InstituicoesDAOTest {
	
	@Autowired
	private InstituicoesDAO instituicoesDAO;
	
	private final String nome = "Unifor";
	private final String novo_nome = "Universidade de Fortaleza";
	private final String sigla = "UNIFOR";
	private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Test
	public void testSalvar() throws Exception {
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(this.nome);
		instituicao.setSigla(this.sigla);
		instituicao.setRegistro(this.timestamp);
		instituicoesDAO.salvar(instituicao);
		
		Assert.assertNotNull(instituicao.getId());
		System.out.println(instituicao.getId());
		instituicoesDAO.excluir(instituicao);
	}
	
	@Test
	public void testAtualizar() throws Exception {

		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(this.nome);
		instituicao.setSigla(this.sigla);
		instituicao.setRegistro(this.timestamp);
		instituicoesDAO.salvar(instituicao);
		
		instituicao.setNome(this.novo_nome);
		instituicoesDAO.atualizar(instituicao);
		
		Assert.assertEquals(this.nome, instituicao.getNome());
		System.out.println("UPDATE::Novo nome para a instituicao::id:"+instituicao.getId());
		instituicoesDAO.excluir(instituicao);
	
	}
	
	@Test
	public void testListaPorNome(){
		List<Instituicoes> instituicao = instituicoesDAO.listarPorNome(this.nome);
		Assert.assertEquals(1, instituicao.size());
	}

}
