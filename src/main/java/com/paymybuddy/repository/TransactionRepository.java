package com.paymybuddy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paymybuddy.model.Transaction;

@Repository
public class TransactionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void createTransaction (Transaction transaction) {
		String query = "INSERT INTO transaction(id_user, id_friend, description, amount) VALUES (?,?,?,?)";

		entityManager //
				.createNativeQuery(query) //
				.setParameter(1, transaction.getIdUser()) //
				.setParameter(2, transaction.getIdFriend())
				.setParameter(3, transaction.getDescription()) //
				.setParameter(4, transaction.getAmount()) //
				.executeUpdate();
	}
	
	@Transactional
	public List<Transaction> getTransactionFromIdUser (Integer idUser) {
		String query = "SELECT * from transaction WHERE id_user= ?";

		List resultList = entityManager //
				.createNativeQuery(query, Transaction.class) //
				.setParameter(1, idUser) //
				.getResultList();
		
		return null;
	}

	
	
	
}
