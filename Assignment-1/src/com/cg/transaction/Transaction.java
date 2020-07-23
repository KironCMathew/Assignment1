package com.cg.transaction;

import java.util.Scanner;

import com.cg.account.Account;
import com.cg.loan.Loan;

public class Transaction extends Loan {
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		private Account[] accounts = new Account[10];
		private Loan[] loans = new Loan[10];
		private int count1= 0;
		private int count= 0;
		
		public long createAccount(double openingBalance)
		{
			if(count < 10) {
			accounts[count]= new Account();
			accounts[count].setBalance(openingBalance);
			count++;
			return accounts[count-1].getAccountId();
			}
			return count;
		}
		
		public void deposit(long accountId, double amount)
		{
			if(amount>0)
			{
				for(int i=0;i<count;i++)
				{
					if(accountId == accounts[i].getAccountId())
					{
						accounts[i].setBalance(accounts[i].getBalance() + amount);
					}
				}
			}

		}
		
		public void withdraw(long accountId, double amount)
		{
			if(amount>0)
			{
				for(int i=0;i<count;i++)
				{
					if(accountId == accounts[i].getAccountId())
					{
					if(accounts[i].getBalance()>= amount)
						accounts[i].setBalance(accounts[i].getBalance()- amount);
					}
				}
			}

		}
		public double getBalance(long accountId)
		{
			for(int i =0; i<count; i++)
			{
				if(accountId == accounts[i].getAccountId())
				{
					return accounts[i].getBalance();			}
			}
			return -1;
		}
		
		public double getLoanBalance(long loanId)
		{
			for(int i =0; i<count; i++)
			{
				if(loanId == loans[i].getLoanId())
				{
					return loans[i].getLoanAmount();		
					}
			}
			
			return -1;
		}
		
		public long applyLoan(long loanId,double amount)
		{
			if(count1 < 10) {
			loans[count1]= new Loan();
			loans[count1].setLoanAmount(amount);
			count1++;
			return loans[count1-1].getLoanId();
			}
			return count1;
		}
		
		public double payLoan(long loanId,double amount)
		{
				for(int i=0;i<count1;i++)
				{
					if(loanId == loans[i].getLoanId())
					{
						loans[i].setLoanAmount(loans[i].getLoanAmount()-amount);
					}
				}
				return -1;
			}

         public void showAccountDetails(long accountId)
		{
			for(int i =0; i<count; i++)
			{
				if(accountId == accounts[i].getAccountId())
				{
			System.out.println("User ID: " + accounts[i].getAccountId() +" Account Balance: " + accounts[i].getBalance());
			}
			}
		}

		
	public static void main(String[] args) {
		Transaction bank= new Transaction();
		
		while(true)
		{
			System.out.println("1. Open Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Apply Loan");
			System.out.println("5. Show Account Details");
			System.out.println("6. Pay Loan");
			System.out.println("7.Exit");
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter option");
			int option = scanner.nextInt();
			
			switch(option)
			{
			case 1 :
				System.out.println("Enter Name");
				bank.setAccountName(scanner.next());
				System.out.println("Enter Address");
				bank.setAddress(scanner.next());
				System.out.println("Enter balance to open account");
				long accountId = bank.createAccount(scanner.nextDouble());
					System.out.println("Account created. And your account number is "+accountId);
				break;
			case 2: 
				System.out.println("Enter account number and amount");
						bank.deposit(scanner.nextLong(), scanner.nextDouble());
						System.out.println("Amount successfully deposited!");
					    break;
			case 3 : System.out.println("Enter account number and amount");
					   bank.withdraw(scanner.nextLong(), scanner.nextDouble());
					   System.out.println("Amount withdrawn successfully!");
					   break;
			case 4 :  System.out.println("Select Loan Type :");
					  bank.setLoanType(scanner.next());
					  System.out.println("Enter Account Id and Loan amount");
					long loanId= bank.applyLoan(scanner.nextLong(), scanner.nextDouble());
					  System.out.println("Loan applied successfully! Your Loan Id is "+ loanId);
					  break;
			case 5: System.out.println("Enter account number");
				   bank.showAccountDetails(scanner.nextLong());
						break;
			case 6: System.out.println("Enter account number and amount");
			     bank.payLoan(scanner.nextLong(), scanner.nextDouble());
			     System.out.println("Loan paid successfully!");
			     double loanRemaining = bank.getLoanBalance(bank.getLoanId());
					System.out.println("Loan Remaining: "+ loanRemaining);
			   		break;
			case 7: System.exit(0);
			break;
			default: 
				System.out.println("invalid");
			
			}
		}
	}
}

