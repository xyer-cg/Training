package srinivas;

import java.math.BigInteger;
import java.util.Scanner;

public class First_10_Digits_Sum
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		BigInteger sum = BigInteger.ZERO;

		int count = Integer.parseInt (sc.nextLine ());
		for (int i = 0; i < count; ++ i)
			sum = sum.add (new BigInteger (sc.nextLine ()));

		String result = sum.toString ();
		System.out.println (result.length () > 10 ? result.substring (0, 10) : result);

		sc.close ();
	}
}