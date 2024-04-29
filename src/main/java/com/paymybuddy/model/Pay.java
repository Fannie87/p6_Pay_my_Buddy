package com.paymybuddy.model;

public class Pay {
	private Integer idUser;
	private String connection;
	private Integer amount;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	} 

	public Integer getAmount() {      
		return amount;
	}

	public void setAmount(Integer amount) {  
		this.amount = amount;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

}
