package br.unifor.pin.saa.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Turmas;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AlunosDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Alunos aluno) {
		entityManager.persist(aluno);
	}

	public void atualizar(Alunos aluno) {
		entityManager.merge(aluno);
	}
	
	public Alunos buscarPorId(Long id) {	
		return (Alunos) entityManager.find(Alunos.class, id);
	}
	
	public void excluir(Alunos aluno) {
		entityManager.remove(aluno);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alunos> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alunos> criteriaQuery = criteriaBuilder.createQuery(Alunos.class);
		Root<Alunos> alunos = criteriaQuery.from(Alunos.class);
		criteriaQuery.where(criteriaBuilder.like(alunos.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Alunos> buscarPorTurma(Long turmaId){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alunos> criteriaQuery = criteriaBuilder.createQuery(Alunos.class);
		Root<Alunos> alunos = criteriaQuery.from(Alunos.class);
		Join<Turmas,Alunos> turmaAluno = alunos.join("turma", JoinType.INNER);
		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(turmaAluno.get("id"), turmaId)));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Alunos> buscarTodos(){
		String jpql = "select a from Alunos a";
		Query query = entityManager.createQuery(jpql);
		return (List<Alunos>)query.getResultList();
	}
}