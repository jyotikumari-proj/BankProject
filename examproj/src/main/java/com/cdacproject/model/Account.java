package com.cdacproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountId")
	private int accountId;
	
	 @Column(name = "accountNo")  
	    private String accountNo;
	
	@Column(name = "balance")  
    private String balance;
	
	 @OneToOne(mappedBy = "account")
	    private User user;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountNo, String balance) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	
	  
	  

}
