package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.PerguntasDAO;
import br.unifor.pin.saa.entity.Perguntas;



@Loggable
@Component
public class PerguntasBO  {

	
	@Autowired
	private PerguntasDAO perguntasDAO;
	
	public void salvar(Perguntas pergunta){

		perguntasDAO.salvar(pergunta);

	}
	
	public void atualizar(Perguntas pergunta){

		perguntasDAO.atualizar(pergunta);

	}
	
	public List<Perguntas> ListarPorNome(String pergunta){

		List<Perguntas> perguntas = perguntasDAO.listarPorNome(pergunta);

		return perguntas;
	}
	
	public Perguntas buscarPorId(Long id){
		return perguntasDAO.buscaPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Perguntas pergunta){

		pergunta = perguntasDAO.buscaPorId(pergunta.getId());
		perguntasDAO.excluir(pergunta);

	}
	
	public List<Perguntas> buscarTodos(){
		return perguntasDAO.buscarTodos();
	}
	
}