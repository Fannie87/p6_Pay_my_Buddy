package com.paymybuddy.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class TransactionDAO {
	@Id
	public Integer idTrade;
	public Integer idUser;
	public Integer idFriend; 
	public String description;
	public Float amount;

	public Integer getIdTrade() {
		return idTrade;
	}

	public void setIdTrade(Integer idTrade) {
		this.idTrade = idTrade;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(Integer idFriend) {
		this.idFriend = idFriend;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
