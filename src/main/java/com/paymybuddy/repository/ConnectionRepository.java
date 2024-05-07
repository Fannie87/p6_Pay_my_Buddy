package com.paymybuddy.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String query = "INSERT INTO connections(id_user, id_friend) VALUES (?,?)";
		entityManager //
				.createNativeQuery(query) //
				.setParameter(1, idUser) //
				.setParameter(2, idFriend) //
				.executeUpdate();
	}

	public BigInteger countConnection(Integer idUser, Integer idFriend) {
		String query = "SELECT count(*) from connections WHERE id_user= ? and id_friend= ?";
		return (BigInteger) entityManager //
				.createNativeQuery(query) //
				.setParameter(1, idUser) //
				.setParameter(2, idFriend).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> getFriendsList(Integer id) {
		String query = "SELECT co.id_friend ,d.mail  FROM connections co JOIN dbuser d ON co.id_friend = d.id WHERE co.id_user =?";
		List<Object[]> resultList = entityManager //
				.createNativeQuery(query) //
				.setParameter(1, id)//
				.getResultList(); //

		Map<Integer, String> mailFriend = new HashMap<Integer, String>();

		for (Object[] objects : resultList)
			mailFriend.put((Integer) objects[0], (String) objects[1]);

		return mailFriend;
	}

}
