package com.paymybuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymybuddy.dao.DBUser;

public interface DBUserRepository extends JpaRepository<DBUser, Integer> {
	public DBUser findByMail(String mail);
}
