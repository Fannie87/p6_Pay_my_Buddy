package com.paymybuddy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paymybuddy.model.Account;

@Repository
public class AccountRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void createAccount (Account account) {
		String query = "INSERT INTO account(iban, bic, nameAccount, idUser) VALUES (?,?,?,?)";
		
		entityManager //
		.createNativeQuery(query) //
		.setParameter(1, account.getIban()) //
		.setParameter(2, account.getBic())
		.setParameter(3, account.getNameAccount()) //
		.setParameter(4, account.getIdUser()) //
		.executeUpdate();

	}

}
