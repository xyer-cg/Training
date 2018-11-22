package com.capgemini.repo;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountException;

public interface RepositoryInterface
{
	public Account save (Account account) throws InvalidAccountException;
	public Account findByAccountNumber (int accountNumber) throws InvalidAccountException;
}
