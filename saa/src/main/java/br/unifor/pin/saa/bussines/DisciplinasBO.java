package br.unifor.pin.saa.bussines;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.DisciplinasDAO;
import br.unifor.pin.saa.entity.Disciplinas;

@Loggable
@Component
public class DisciplinasBO {
	
	@Autowired
	private DisciplinasDAO disciplinasDAO;
	
	public void salvar(Disciplinas disciplina) {
		
		disciplinasDAO.salvar(disciplina);
		
	}

	public void atualizar(Disciplinas disciplina){
		
		disciplinasDAO.atualizar(disciplina);
		
	}

	public List<Disciplinas> ListarPorNome(String nome) {
		
		List<Disciplinas> disciplina = disciplinasDAO.listarPorNome(nome);
		
		return disciplina;
	}
	
	public Disciplinas buscarPorId(Long id){
		return disciplinasDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Disciplinas disciplina) {
		
		disciplina = disciplinasDAO.buscarPorId(disciplina.getId());
		disciplinasDAO.excluir(disciplina);
		
	}
	
	public List<Disciplinas> buscarTodos(){
		return disciplinasDAO.buscarTodos();
	}
	
}