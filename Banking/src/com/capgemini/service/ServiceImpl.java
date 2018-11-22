package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountException;
import com.capgemini.repo.RepositoryInterface;

@Service
public class ServiceImpl implements ServiceInterface
{
	@Autowired
	private RepositoryInterface repository;

	public ServiceImpl ()
	{
		super ();
	}
	
	public ServiceImpl (RepositoryInterface repository)
	{
		this.repository = repository;
	}
	
	@Override
	public Account createAccount (int accountNumber, String name, double amount) throws InsufficientOpeningBalance, InvalidAccountException
	{
		if (accountNumber < 0) throw new InvalidAccountException ("Invalid account number!");
		if (name == null || !name.matches ("[a-zA-Z ]+")) throw new InvalidAccountException ("Invalid name!");
		if (amount < 500) throw new InsufficientOpeningBalance ("Minimum opening balance is 500!");
		
		Account account = new Account (accountNumber, name, amount);
		return repository.save (account);
	}

	@Override
	public Account depositAmount (int accountNumber, double amount) throws InvalidAccountException
	{
		if (accountNumber < 0) throw new InvalidAccountException ("Invalid account number!");

		Account account = repository.findByAccountNumber (accountNumber);
		
		if (amount > 0)
		{
			account.setAmount (account.getAmount () + amount);
			repository.save (account);
		}
		
		return account;
	}

	@Override
	public Account withdrawAmount (int accountNumber, double amount) throws InsufficientBalanceException, InvalidAccountException
	{
		if (accountNumber < 0) throw new InvalidAccountException ("Invalid account number!");
		
		Account account = repository.findByAccountNumber (accountNumber);
		
		if (amount > account.getAmount ()) throw new InsufficientBalanceException ("Insufficient balance!");
		
		account.setAmount (account.getAmount () - amount);
		
		repository.save (account);
		return account;
	}

	@Override
	public Account fundTransfer (int from, int to, double amount) throws InsufficientBalanceException, InvalidAccountException
	{
		if (from < 0 || to < 0) throw new InvalidAccountException ("Invalid account number!");
		
		Account fromAccount = repository.findByAccountNumber (from);
		Account toAccount = repository.findByAccountNumber (to);
		
		if (amount > fromAccount.getAmount ()) throw new InsufficientBalanceException ("Insufficient Balance!");
		
		if (amount > 0)
		{
			fromAccount.setAmount (fromAccount.getAmount () - amount);
			toAccount.setAmount (toAccount.getAmount () + amount);
			
			repository.save (fromAccount);
			repository.save (toAccount);
		}
		
		return fromAccount;
	}
}
