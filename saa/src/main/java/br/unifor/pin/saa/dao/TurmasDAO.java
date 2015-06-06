package br.unifor.pin.saa.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turmas;
import br.unifor.pin.saa.entity.Instituicoes;

@SuppressWarnings("unused")
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TurmasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Turmas turma) {
		entityManager.persist(turma);
	}

	public void atualizar(Turmas turma) {
		entityManager.merge(turma);
	}
	
	public Turmas buscaPorId(Long id) {	
		return (Turmas) entityManager.find(Turmas.class, id);
	}
	
	
	public void excluir(Turmas turma) {
		entityManager.remove(turma);
	}
	
	@SuppressWarnings("unchecked")
	public List<Turmas> listarPorNome(String turma){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Turmas> criteriaQuery = criteriaBuilder.createQuery(Turmas.class);
		Root<Turmas> turmas = criteriaQuery.from(Turmas.class);
		criteriaQuery.where(criteriaBuilder.like(turmas.<String>get("turma"), "%"+turma+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();		
	}
}