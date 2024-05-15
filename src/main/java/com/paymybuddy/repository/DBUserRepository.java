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
					.createNativeQuery("select * from dbuser where mail = :mail", DBUser.class) //
					.setParameter("mail", mail) //
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
					.createNativeQuery("select count(*) from dbuser where mail = :mail") //
					.setParameter("mail", mail) //
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
			String query = " INSERT INTO dbuser(mail, password, first_name, last_name) VALUES (:mail, :password, :first_name, :last_name)";

			entityManager //
					.createNativeQuery(query) //
					.setParameter("mail", registration.getMail()) //
					.setParameter("password", bCryptPasswordEncoder.encode(registration.getPassword())) //
					.setParameter("first_name", registration.getFirstName()) //
					.setParameter("last_name", registration.getLastName()) //
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public Float getBalance(Integer idUser) {
		try {
			String query = "SELECT balance FROM dbuser WHERE id = :idUser";
			return (Float) entityManager //
					.createNativeQuery(query) //
					.setParameter("idUser", idUser) //
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public DBUser getUserById(Integer idUser) {
		try {
			String query = "SELECT * FROM dbuser WHERE id = :idUser";
			return (DBUser) entityManager //
					.createNativeQuery(query, DBUser.class) //
					.setParameter("idUser", idUser) //
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
			String query = " UPDATE dbuser SET balance = :balance WHERE id = :idUser";
			entityManager //
					.createNativeQuery(query) //
					.setParameter("balance", balance) //
					.setParameter("idUser", idUser).executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
