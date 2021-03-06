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

import br.unifor.pin.saa.entity.Professores;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ProfessoresDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Professores professor) {
		entityManager.persist(professor);
	}

	public void atualizar(Professores professor) {
		entityManager.merge(professor);
	}
	
	public Professores buscarPorId(Long id) {
		return (Professores) entityManager.find(Professores.class, id);
	}
	
	public void excluir(Professores professor) {
		entityManager.remove(professor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professores> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Professores> criteriaQuery = criteriaBuilder.createQuery(Professores.class);
		Root<Professores> professores = criteriaQuery.from(Professores.class);
		criteriaQuery.where(criteriaBuilder.like(professores.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Professores> buscarTodos(){
		String jpql = "select p from Professores p";
		Query query = entityManager.createQuery(jpql);
		return (List<Professores>)query.getResultList();
	}
}