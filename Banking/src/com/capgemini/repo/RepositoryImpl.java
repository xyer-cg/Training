package com.capgemini.repo;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountException;

@Repository
public class RepositoryImpl implements RepositoryInterface
{
	@Resource (name = "map")
	private Map <Integer, Account> accounts;
	
	public RepositoryImpl ()
	{
		super ();
	}
	
	public RepositoryImpl (Map <Integer, Account> accounts)
	{
		this.accounts = accounts;
	}

	@Override
	public Account save (Account account) throws InvalidAccountException
	{
		validate (account);
		accounts.put (account.getAccountNumber (), account);
		return account;
	}

	@Override
	public Account findByAccountNumber (int accountNumber) throws InvalidAccountException
	{
		Account account = accounts.get (accountNumber);
		if (account == null) throw new InvalidAccountException ("Account not found!");
		return account;
	}
	
	private void validate (Account account) throws InvalidAccountException
	{
		if (account.getAccountNumber () < 0) throw new InvalidAccountException ("Invalid Account Number!");
		if (account.getName () == null || !account.getName ().matches ("[a-zA-Z ]+")) throw new InvalidAccountException ("Invalid Name!");
	}
}