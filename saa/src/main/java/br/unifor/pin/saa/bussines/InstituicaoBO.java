package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.InstituicoesDAO;
import br.unifor.pin.saa.entity.Instituicoes;
@Loggable
@Component
public class InstituicaoBO {


	@Autowired
	private InstituicoesDAO instituicoesDAO;

	public void salvar(Instituicoes instituicao) {

		instituicoesDAO.salvar(instituicao);

	}

	public List<Instituicoes> listaPorNome(String nome) {

		List<Instituicoes> instituicao = instituicoesDAO.listarPorNome(nome);

		return instituicao;
	}
	
	public void atualizar(Instituicoes instituicao) {

		instituicoesDAO.atualizar(instituicao);

	}
	
	public Instituicoes buscaPorId(Long id){
		return instituicoesDAO.buscaPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Instituicoes instituicoes) {

		instituicoes = instituicoesDAO.buscaPorId(instituicoes.getId());
		instituicoesDAO.excluir(instituicoes);

	}

	public List<Instituicoes> buscarTodos(){
		return instituicoesDAO.buscarTodos();
	}
		
}
