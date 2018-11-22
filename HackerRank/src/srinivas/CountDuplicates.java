package srinivas;

import java.util.ArrayList;
import java.util.List;

public class CountDuplicates
{
	public static void main (String [] args)
	{
		List <Integer> unique = new ArrayList <Integer> ();
		List <Integer> checked = new ArrayList <Integer> ();

		int array[] = { 1, 3, 1, 4, 5, 6, 3, 2 };

		for (int i : array)
		{
			if (!unique.contains (i))
				unique.add (i);
			else if (!checked.contains (i))
				checked.add (i);
		}

		System.out.println (checked.size ());
	}
}
