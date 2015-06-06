package br.unifor.pin.saa.bussines;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AlunosDAO;
import br.unifor.pin.saa.entity.Alunos;
@Loggable
@Component
public class AlunosBO {
	
	@Autowired
	private AlunosDAO alunosDAO;
	
	public void salvar(Alunos aluno) {

		alunosDAO.salvar(aluno);

	}

	public void atualizar(Alunos aluno){

		alunosDAO.atualizar(aluno);

	}

	public List<Alunos> ListarPorNome(String nome) {

		List<Alunos> aluno = alunosDAO.listarPorNome(nome);

		return aluno;
	}
	
	public Alunos buscarPorId(Long id){
		return alunosDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Alunos aluno) {

		aluno = alunosDAO.buscarPorId(aluno.getId());
		alunosDAO.excluir(aluno);

	}
	
	public List<Alunos> buscarTodos(){
		return alunosDAO.buscarTodos();
	}
	
}