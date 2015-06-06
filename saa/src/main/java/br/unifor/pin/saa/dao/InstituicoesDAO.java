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

import br.unifor.pin.saa.entity.Instituicoes;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicoesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Instituicoes instituicao) {
		entityManager.persist(instituicao);
	}

	public void atualizar(Instituicoes instituicao) {
		entityManager.merge(instituicao);
	}
	
	public Instituicoes buscaPorId(Long id) {
		return (Instituicoes) entityManager.find(Instituicoes.class, id);
		
	}
	
	public void excluir(Instituicoes instituicao) {
		entityManager.remove(instituicao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Instituicoes> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Instituicoes> criteriaQuery = criteriaBuilder.createQuery(Instituicoes.class);
		Root<Instituicoes> instituicao = criteriaQuery.from(Instituicoes.class);
		criteriaQuery.where(criteriaBuilder.like(instituicao.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Instituicoes> buscarTodos(){
		String jpql = "select i from Instituicoes i";
		Query query = entityManager.createQuery(jpql);
		return (List<Instituicoes>)query.getResultList();
	}
}