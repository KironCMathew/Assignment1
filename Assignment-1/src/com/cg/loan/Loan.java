package com.cg.loan;

import com.cg.account.Account;

public class Loan extends Account{

	private long loanId;
	private String loanType;
	private double loanAmount;
	private long loanIdGen= 123000;

	
	public Loan() {
		loanId = ++loanIdGen;
		// TODO Auto-generated constructor stub
	}
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double d) {
		this.loanAmount = d;
	}
	
}