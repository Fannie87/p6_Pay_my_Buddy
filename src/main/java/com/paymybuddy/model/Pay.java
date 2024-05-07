package com.paymybuddy.model;

public class Pay {
	private Integer idUser;
	private String connection;
	private Float amount;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	} 

	public Float getAmount() {      
		return amount;
	}

	public void setAmount(Float amount) {  
		this.amount = amount;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

}
