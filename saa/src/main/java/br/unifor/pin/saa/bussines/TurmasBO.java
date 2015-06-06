package br.unifor.pin.saa.bussines;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.TurmasDAO;
import br.unifor.pin.saa.entity.Turmas;

@Loggable
@Component
public class TurmasBO {
	
	@Autowired
	private TurmasDAO turmasDAO;
	
	public void salvar(Turmas turma){

		turmasDAO.salvar(turma);

	}
	
	public void atualizar(Turmas turma){

		turmasDAO.atualizar(turma);

	}
	
	public List<Turmas> listarPorNome(String nome){

		List<Turmas> turma = turmasDAO.listarPorNome(nome);

		return turma;
	}
	
	public Turmas buscarPorId(Long id){
		return turmasDAO.buscaPorId(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Turmas turma){

		turma = turmasDAO.buscaPorId(turma.getId());
		turmasDAO.excluir(turma);

	}
	
}
