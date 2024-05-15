package com.paymybuddy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paymybuddy.dao.TransactionDAO;

@Repository
public class TransactionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void createTransaction(TransactionDAO transaction) {
		try {

			String query = "INSERT INTO transaction(id_user, id_friend, description, amount) VALUES (:id_user, :id_friend, :description, :amount)";

			entityManager //
					.createNativeQuery(query) //
					.setParameter("id_user", transaction.getIdUser()) //
					.setParameter("id_friend", transaction.getIdFriend())//
					.setParameter("description", transaction.getDescription()) //
					.setParameter("amount", transaction.getAmount()) //
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Transactional
	public List<TransactionDAO> getTransactionsFromIdUser(Integer idUser) {
		try {
			String query = "SELECT * from transaction WHERE id_user= :id_user";
			return entityManager //
					.createNativeQuery(query, TransactionDAO.class) //
					.setParameter("id_user", idUser) //
					.getResultList();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
