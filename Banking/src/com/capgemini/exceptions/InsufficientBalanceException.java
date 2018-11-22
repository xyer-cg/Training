package com.capgemini.exceptions;

public class InsufficientBalanceException extends Exception
{
	private static final long serialVersionUID = 7100665572007695519L;

	public InsufficientBalanceException (String message)
	{
		super ("*** " + message + " ***");
	}
}
