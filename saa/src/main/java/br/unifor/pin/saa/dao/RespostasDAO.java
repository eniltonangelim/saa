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

import br.unifor.pin.saa.entity.Respostas;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RespostasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Respostas resposta) {
		entityManager.persist(resposta);
	}

	public void atualizar(Respostas responda) {
		entityManager.merge(responda);
	}
	
	public Respostas buscaPorId(Long id) {
		return (Respostas) entityManager.find(Respostas.class, id);
	}
		
	public void excluir(Respostas resposta) {
		entityManager.remove(resposta);
	}
	
	@SuppressWarnings("unchecked")
	public List<Respostas> listarPorNome(String respostas2) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Respostas> criteriaQuery = criteriaBuilder.createQuery(Respostas.class);
		Root<Respostas> respostas = criteriaQuery.from(Respostas.class);
		criteriaQuery.where(criteriaBuilder.like(respostas.<String>get("resposta"), "%"+respostas+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Respostas> buscarTodos(){
		String jpql = "select r from Respostas r";
		Query query = entityManager.createQuery(jpql);
		return (List<Respostas>)query.getResultList();
	}
	
}