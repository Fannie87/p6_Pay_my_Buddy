package com.paymybuddy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Entity = table + son nom
@Entity(name = "account")
public class Account {
	@Id //=clé primaire
	private Integer idAccount;
	private Integer idUser;
	private String iban;
	private String bic;
	private String nameAccount;
 
	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
