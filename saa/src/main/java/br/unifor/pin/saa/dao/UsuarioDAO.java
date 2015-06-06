package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Usuarios usuario) {
		entityManager.persist(usuario);
	}
	
	public void atualizar(Usuarios usuario){
		entityManager.merge(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuarios> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> usuarios = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.like(usuarios.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Usuarios buscaLogin(String nome){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> usuarios = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.like(usuarios.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		
		return (Usuarios) query.getSingleResult();
	}

	
	public Usuarios buscaPorId(Integer id) throws DAOException {
		String jpql = "select u from Usuarios u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Usuarios) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
		
	}
	
	public void excluir(Usuarios usuario) {
		entityManager.remove(usuario);
	}
}
