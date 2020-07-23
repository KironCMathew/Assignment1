package com.cg.account;

import java.util.Scanner;

import com.cg.transaction.Transaction;

public class Account {

	private long accountId;
	private String accountName;
	private String address;
	private double balance;
	private long accountIdGen= 123000;
	
	public Account() {
		accountId = ++accountIdGen;
	}
	

	public Account(long accountId, String accountName, String address, double balance, long accountIdGen) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.balance = balance;
		this.accountIdGen = accountIdGen;
	}


	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	
	
}