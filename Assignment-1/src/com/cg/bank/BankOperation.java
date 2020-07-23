package com.cg.bank;

import com.cg.account.Account;

	public class BankOperation
	{
		private Account[] accounts = new Account[10];
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
			for(int i =0; i<=10; i++)
			{
				if(accountId == accounts[i].getAccountId())
				{
					return accounts[i].getBalance();			}
			}
			return -1;
		}
		
	}
