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
		try {
			entityManager //
					.createNativeQuery(query) //
					.setParameter(1, account.getIban()) //
					.setParameter(2, account.getBic()).setParameter(3, account.getNameAccount()) //
					.setParameter(4, account.getIdUser()) //
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public List<Account> getAccountsFromIdUser(Integer idUser) {
		try {
			String query = "SELECT * from account WHERE id_user= ?";
			return entityManager //
					.createNativeQuery(query, Account.class) //
					.setParameter(1, idUser) //
					.getResultList();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public Account getAccountFromId(String idAccount) {
		try {
			String query = "SELECT * from account WHERE id_account= ?";
			return (Account) entityManager //
					.createNativeQuery(query, Account.class) //
					.setParameter(1, idAccount) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
