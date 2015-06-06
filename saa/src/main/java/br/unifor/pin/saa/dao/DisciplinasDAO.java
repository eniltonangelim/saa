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

import br.unifor.pin.saa.entity.Disciplinas;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DisciplinasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Disciplinas disciplina) {
		entityManager.persist(disciplina);
	}

	public void atualizar(Disciplinas disciplina) {
		entityManager.merge(disciplina);
	}
	
	public Disciplinas buscarPorId(Long id) {
		return (Disciplinas) entityManager.find(Disciplinas.class, id);
	}
	
	public void excluir(Disciplinas disciplina) {
		entityManager.remove(disciplina);
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplinas> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Disciplinas> criteriaQuery = criteriaBuilder.createQuery(Disciplinas.class);
		Root<Disciplinas> disciplinas = criteriaQuery.from(Disciplinas.class);
		criteriaQuery.where(criteriaBuilder.like(disciplinas.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	

	@SuppressWarnings("unchecked")
	public List<Disciplinas> buscarTodos(){
		String jpql = "select d from Disciplinas d";
		Query query = entityManager.createQuery(jpql);
		return (List<Disciplinas>)query.getResultList();
	}
}