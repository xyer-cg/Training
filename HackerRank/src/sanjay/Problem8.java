package sanjay;

public class Problem8
{
	public static void main (String [] args)
	{
/*		int [] A = new int [args.length];

		for (int i = 0; i < args.length; ++ i)

			A [i] = Integer.parseInt (args [i]);*/
		
		int [] A = {1234, 1324, 12, 341, 241, 23, 4, 132, 4, 324, 123, 4123, 4, 2, 41, 324, 3, 4, 123412};
		
		System.out.println ("Solution is : " + solution (A));
	}

	public static int solution (int [] A)
	{
		if (A.length == 0) return 0;
		if (A.length == 1) return A [0];

		int sums [] = new int [A.length + 1];
		sums [0] = 0;

		for (int i = 1; i < sums.length; ++ i)
		{
			sums [i] = sums [i - 1] + A [i - 1];
			System.out.println ("Sum of (0, " + (i - 1) + ") = " + sums [i]);
		}

		int min = sums [1];

		for (int i = 2; i < sums.length; ++ i)
		{
			min = Math.min (Math.abs (sums [i] - sums [i - 1]), min);
		}

		System.out.println ("------------------------------");
		return min;
	}
}