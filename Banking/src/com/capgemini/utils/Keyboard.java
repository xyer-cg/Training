package com.capgemini.utils;

public class Keyboard
{
	@SuppressWarnings ("resource")
	public static String readString (String prompt)
	{
		System.out.print (prompt);
		return new java.util.Scanner (System.in).nextLine ();
	}
	
	public static int readInt (String prompt)
	{
		int input;

		try
		{
			input = Integer.parseInt (readString (prompt));
		}
		catch (NumberFormatException nfe)
		{
			System.out.println (ERROR.INTEGER);
			return readInt (prompt);
		}

		return input;
	}
	
	public static double readDouble (String prompt)
	{
		double input;

		try
		{
			input = Double.parseDouble (readString (prompt));
		}
		catch (NumberFormatException nfe)
		{
			System.out.println (ERROR.DOUBLE);
			return readDouble (prompt);
		}

		return input;
	}
	
	public static int menuInput (String title, String menu [])
	{
		printLine ('=', 50);
		System.out.println (title.toUpperCase ());
		printLine ('-', 50);

		for (int i = 0; i < menu.length; ++ i)

			System.out.println ("[" + (i + 1) + "] " + menu [i]);

		System.out.println ("[0] Quit");
		printLine ('-', 50);

		int choice = readInt ("Your Choice : ");

		while (choice < 0 || choice > menu.length)
		{
			System.out.println (ERROR.OPTION);
			choice = readInt ("Your Choice : ");
		}

		return choice;
	}

	private static void printLine (char symbol, int length)
	{
		for (int i = 0; i < length; ++ i)

			System.out.print (symbol);

		System.out.println ();
	}

	private static enum ERROR
	{
		CHAR, INTEGER, FLOAT, DOUBLE, DATE_FORMAT, DATE, OPTION;

		public String toString ()
		{
			switch (this)
			{
				case CHAR:
					return "*** Please enter a char ***";

				case INTEGER:
					return "*** Please enter an integer ***";

				case FLOAT:
					return "*** Please enter a float ***";

				case DOUBLE:
					return "*** Please enter a double ***";

				case DATE_FORMAT:
					return "*** Invalid date format ***";

				case DATE:
					return "*** Invalid date ***";

				case OPTION:
					return "*** Invalid option ***";
			}

			return "";
		};
	}
}
