package br.unifor.pin.saa.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Token;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TokenDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Token token) {
		entityManager.persist(token);
	}

	public void atualizar(Token token) {
		entityManager.merge(token);
	}
	
	public Token buscaPorId(Long id) {	
		return (Token) entityManager.find(Token.class, id);
	}
	
	public void excluir(Token token) {
		entityManager.remove(token);
	}
}