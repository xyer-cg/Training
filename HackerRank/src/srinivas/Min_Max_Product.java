package srinivas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Min_Max_Product
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);

		String commands[] = new String [Integer.parseInt (sc.nextLine ())];

		for (int i = 0; i < commands.length; ++ i)
			commands [i] = sc.nextLine ();

		List <Integer> stack = new ArrayList <Integer> ();
		List <Integer> products = new ArrayList <Integer> ();

		sc.nextLine ();

		for (String command : commands)
		{
			switch (command)
			{
				case "push":
					stack.add (Integer.parseInt (sc.nextLine ()));
					Collections.sort (stack);
					break;

				case "pop":
					if (stack.size () > 0)
						stack.remove (new Integer (sc.nextLine ()));
			}
			products.add (stack.get (0) * stack.get (stack.size () - 1));
		}

		System.out.println (products);
		sc.close ();
	}
}
