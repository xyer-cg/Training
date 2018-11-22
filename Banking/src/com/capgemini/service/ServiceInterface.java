package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountException;

public interface ServiceInterface
{
	public Account createAccount (int accountNumber, String name, double amount) throws InsufficientOpeningBalance, InvalidAccountException;
	public Account depositAmount (int accountNumber, double amount) throws InvalidAccountException;
	public Account withdrawAmount (int accountNumber, double amount) throws InsufficientBalanceException, InvalidAccountException;
	public Account fundTransfer (int from, int to, double amount) throws InsufficientBalanceException, InvalidAccountException;
}