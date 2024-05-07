package com.paymybuddy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paymybuddy.model.Account;

@Repository
@SuppressWarnings("unchecked")
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void createAccount(Account account) {
		String query = "INSERT INTO account(iban, bic, name_account, id_user) VALUES (?,?,?,?)";

		entityManager //
				.createNativeQuery(query) //
				.setParameter(1, account.getIban()) //
				.setParameter(2, account.getBic()).setParameter(3, account.getNameAccount()) //
				.setParameter(4, account.getIdUser()) //
				.executeUpdate();
	}

	public List<Account> getAccounts(Integer idUser) {
		String query = "SELECT * from account WHERE id_user= ?";
		return entityManager //
				.createNativeQuery(query , Account.class) //
				.setParameter(1, idUser) //
				.getResultList();
	}
}
