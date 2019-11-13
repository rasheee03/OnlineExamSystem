package com.lti.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACCOUNT")

public class Account {
	
	@Id
	private int acno;

    private String name;

	
	@Column(name="AC_TYPE")
	private String type;

	private double balance;
	

	@OneToMany(mappedBy =  "account" ,cascade=CascadeType.ALL)
	private List<Transaction> transactions;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [acno=" + acno + ", name=" + name + ", type=" + type + ", balance=" + balance
				+ "]";
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	
}
