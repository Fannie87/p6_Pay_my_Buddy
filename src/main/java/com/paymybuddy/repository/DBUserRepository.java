package com.paymybuddy.repository;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.model.Registration;

@Repository
public class DBUserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public DBUser findByMail(String mail) {
		try {
			return (DBUser) entityManager //
					.createNativeQuery("select * from dbuser where mail = ?", DBUser.class) //
					.setParameter(1, mail) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public BigInteger countByMail(String mail) {
		try {
			return (BigInteger) entityManager //
					.createNativeQuery("select count(*) from dbuser where mail = ?") //
					.setParameter(1, mail) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Transactional
	public void createUser(Registration registration) {
		try {
			String query = " INSERT INTO dbuser(mail, password, first_name, last_name) VALUES (?,?,?,?)";

			entityManager //
					.createNativeQuery(query) //
					.setParameter(1, registration.getMail()) //
					.setParameter(2, bCryptPasswordEncoder.encode(registration.getPassword())) //
					.setParameter(3, registration.getFirstName()) //
					.setParameter(4, registration.getLastName()) //
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public Float getBalance(Integer idUser) {
		try {
			String query = "SELECT balance FROM dbuser WHERE id = ?";
			return (Float) entityManager //
					.createNativeQuery(query) //
					.setParameter(1, idUser) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public DBUser getUserById(Integer idUser) {
		try {
			String query = "SELECT * FROM dbuser WHERE id = ?";
			return (DBUser) entityManager //
					.createNativeQuery(query, DBUser.class) //
					.setParameter(1, idUser) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Transactional
	public void loadBalance(Integer idUser, Float balance) {
		try {
			String query = " UPDATE dbuser SET balance = ? WHERE id = ?";
			entityManager //
					.createNativeQuery(query) //
					.setParameter(1, balance) //
					.setParameter(2, idUser).executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
