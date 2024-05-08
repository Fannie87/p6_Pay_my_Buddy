package com.paymybuddy.model;

public class Transaction {
	private Integer idTrade;
	private String friend; 
	private String description;
	private Float amount;
	public Integer getIdTrade() {
		return idTrade;
	}
	public void setIdTrade(Integer idTrade) {
		this.idTrade = idTrade;
	}
	public String getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
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
