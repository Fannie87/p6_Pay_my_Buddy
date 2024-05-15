package com.paymybuddy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.paymybuddy.dao.Account;

@Repository
@SuppressWarnings("unchecked")
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void createAccount(Account account) {
		String query = "INSERT INTO account(iban, bic, name_account, id_user) VALUES (:iban, :bic, :name_account, :id_user)";
		try {
			entityManager //
					.createNativeQuery(query) //
					.setParameter("iban", account.getIban()) //
					.setParameter("bic", account.getBic())//
					.setParameter("name_account", account.getNameAccount()) //
					.setParameter("id_user", account.getIdUser()) //
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public List<Account> getAccountsFromIdUser(Integer idUser) {
		try {
			String query = "SELECT * from account WHERE id_user= :id_user";
			return entityManager //
					.createNativeQuery(query, Account.class) //
					.setParameter("id_user", idUser) //
					.getResultList();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public Account getAccountFromId(String idAccount) {
		try {
			String query = "SELECT * from account WHERE id_account= :id_account";
			return (Account) entityManager //
					.createNativeQuery(query, Account.class) //
					.setParameter("id_account", idAccount) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
