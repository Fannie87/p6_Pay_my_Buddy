package com.paymybuddy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addConnection(Integer idUser, Integer idFriend) {
		String query = "INSERT INTO connections(idUser, idFriend) VALUES (?,?)";
 // TODO attention doublon
		entityManager // 
				.createNativeQuery(query) //
				.setParameter(1,idUser) //
				.setParameter(2,idFriend) //
				.executeUpdate();

	}

	
}
