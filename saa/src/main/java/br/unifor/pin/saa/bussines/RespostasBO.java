package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.RespostasDAO;
import br.unifor.pin.saa.entity.Respostas;


@Loggable
@Component
public class RespostasBO  {

	
	
	@Autowired
	private RespostasDAO respostasDAO;
	
	public void salvar(Respostas resposta){
		
		respostasDAO.salvar(resposta);
		
	}
	
	public void atualizar(Respostas resposta){
		
		respostasDAO.atualizar(resposta);
		
	}
	
	public List<Respostas> ListarPorNome(String respostas){
		
		List<Respostas> perguntas = respostasDAO.listarPorNome(respostas);
		
		return perguntas;
	}
	
	public Respostas buscarPorId(Long id){
		return respostasDAO.buscaPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Respostas resposta){
		
		resposta = respostasDAO.buscaPorId(resposta.getId());
		respostasDAO.excluir(resposta);
		
	}
	
}