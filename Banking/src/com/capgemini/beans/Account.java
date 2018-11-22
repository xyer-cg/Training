package com.capgemini.beans;

public class Account
{
	private int accountNumber;
	private String name;
	private double amount;

	public Account (int accountNumber, String name, double amount)
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}

	public int getAccountNumber ()
	{
		return accountNumber;
	}

	public void setAccountNumber (int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public double getAmount ()
	{
		return amount;
	}

	public void setAmount (double amount)
	{
		this.amount = amount;
	}

	
	
	@Override
	public String toString ()
	{
		return "\nAccount" +
			   "\n-------" + 
			   "\nAccount Number : " + accountNumber +
			   "\nName           : " + name +
			   "\nAmount         : " + amount + "\n";
	}

	@Override
	public int hashCode ()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}

	@Override
	public boolean equals (Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass () != obj.getClass ()) return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber) return false;
		return true;
	}
}
