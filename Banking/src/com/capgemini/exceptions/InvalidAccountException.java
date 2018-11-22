package com.capgemini.exceptions;

public class InvalidAccountException extends Exception
{
	private static final long serialVersionUID = -1564631548944630897L;

	public InvalidAccountException (String message)
	{
		super ("*** " + message + " ***");
	}
}
