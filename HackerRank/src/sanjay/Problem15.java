package sanjay;

public class Problem15
{
	@SuppressWarnings ("resource")
	public static void main (String [] args)
	{
		// if (args.length == 0) return;

		String input = new java.util.Scanner (System.in).nextLine ();
		if (!input.matches ("[\\(\\)]+")) return;
		
		System.out.println ("Solution k = " + solution (input));
		System.out.println ("Solution2 k = " + solution2 (input));
	}

	public static int solution (String s)
	{
		if (s.length () == 0) return 0;

		char sArr [] = s.toCharArray ();

		int k = -1, kPrime = sArr.length;
		int left = 0, right = 0;

		while (kPrime - k > 1)
		{
			if (left == right)
			{
				if (sArr [++ k] == '(') left ++;
				if (sArr [-- kPrime] == ')') right ++;
			}
			else if (left < right)
			{
				if (sArr [++ k] == '(') left ++;
			}
			else
			{
				if (sArr [-- kPrime] == ')') right ++;
			}
		}

		if (right == 0) return 0;
		if (left == 0) return s.length ();

		return left > right ? k : k + 1;
	}

	public static int solution2 (String s)
	{
		if (s.length () == 0) return 0;

		int k = s.length () / 2;

		int left = k, right = -1;
		while (left != right)
		{
			left = s.substring (0, k).replace (")", "").length ();
			right = s.substring (k).replace ("(", "").length ();
			
			if (left < right) k ++;
			else if (left > right) k --;							
		}

		return k;
	}
}