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

import br.unifor.pin.saa.entity.Perguntas;



@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PerguntasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Perguntas pergunta) {
		entityManager.persist(pergunta);
	}

	public void atualizar(Perguntas pergunta) {
		entityManager.merge(pergunta);
	}
	
	public Perguntas buscaPorId(Long id) {
		return (Perguntas) entityManager.find(Perguntas.class, id);
	}
	
	public void excluir(Perguntas pergunta) {
		entityManager.remove(pergunta);
	}
	
	@SuppressWarnings("unchecked")
	public List<Perguntas> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Perguntas> criteriaQuery = criteriaBuilder.createQuery(Perguntas.class);
		Root<Perguntas> pergunta = criteriaQuery.from(Perguntas.class);
		criteriaQuery.where(criteriaBuilder.like(pergunta.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Perguntas> buscarTodos(){
		String jpql = "select p from Perguntas p";
		Query query = entityManager.createQuery(jpql);
		return (List<Perguntas>)query.getResultList();
	}
}