package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.ProfessoresDAO;
import br.unifor.pin.saa.entity.Professores;

@Loggable
@Component
public class ProfessoresBO {
    
	@Autowired
	private ProfessoresDAO professoresDAO;
	
	public void salvar(Professores professor)  {
		
		professoresDAO.salvar(professor);
		
	}

	public void atualizar(Professores professor){
		
		professoresDAO.atualizar(professor);
		
	}

	public List<Professores> ListarPorNome(String nome) {
		
		List<Professores> professor = professoresDAO.listarPorNome(nome);
		
		return professor;
	}
	
	public Professores buscarPorId(Long id){
		return professoresDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Professores professor) {
		
		professor = professoresDAO.buscarPorId(professor.getId());
		professoresDAO.excluir(professor);
		
	}
	
	public List<Professores> buscarTodos(){
		return professoresDAO.buscarTodos();
	}

}
