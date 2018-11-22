package srinivas;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_String_Ascending
{
	public static void main (String [] args)
	{
		String strings[] = { "31415926535897932384626433832795", "1", "3", "10", "3", "5" };
		Arrays.sort (strings, new Comparator <String> ()
		{
			@Override
			public int compare (String o1, String o2)
			{
				if (o1.length () > o2.length ())
					return 1;
				if (o1.length () < o2.length ())
					return -1;

				return o1.charAt (0) > o2.charAt (0) ? 1 : -1;
			}
		});
		System.out.println (Arrays.toString (strings));
	}
}
