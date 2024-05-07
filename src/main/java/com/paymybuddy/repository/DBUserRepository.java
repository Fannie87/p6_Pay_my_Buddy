package com.paymybuddy.repository;

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
		return (DBUser) entityManager //
				.createNativeQuery("select * from dbuser where mail = ?", DBUser.class) //
				.setParameter(1, mail) //
				.getSingleResult();
	}
	
	@Transactional
	public void createUser(Registration registration) {
		String query = " INSERT INTO dbuser(mail, password, first_name, last_name) VALUES (?,?,?,?)";

		entityManager //
				.createNativeQuery(query) //
				.setParameter(1, registration.getMail()) //
				.setParameter(2, bCryptPasswordEncoder.encode(registration.getPassword()))
				.setParameter(3, registration.getFirstName()) //
				.setParameter(4, registration.getLastName()) //
				.executeUpdate();
	}
	
	public Float getBalance (Integer idUser) {
		String query = "SELECT balance FROM dbuser WHERE id = ?";
		return (Float) entityManager //
				.createNativeQuery(query) //
				.setParameter(1, idUser) //
				.getSingleResult();
	}
	
	
	@Transactional
	public void loadBalance(Integer idUser, Float balance) {
		String query = " UPDATE dbuser SET balance = ? WHERE id = ?";

		entityManager //
				.createNativeQuery(query) //
				.setParameter(1, balance) //
				.setParameter(2, idUser)
				.executeUpdate();
	}
	

}
