package com.capgemini.exceptions;

public class InsufficientOpeningBalance extends Exception
{
	private static final long serialVersionUID = -1351770123717057017L;

	public InsufficientOpeningBalance (String message)
	{
		super ("*** " + message + " ***");
	}
}
