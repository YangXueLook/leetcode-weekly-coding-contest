package lc1020;

public class Q2
{
	public static int minFlipsMonoIncr(String S)
	{
		int[] a1 = new int[S.length()];
		int[] a2 = new int[S.length()];
		int c0 = 0;
		int c1 = 0;
		

		a1[0] = 0;
		for (int i = 1; i < S.length(); i++)
		{
			if (S.charAt(i - 1) == '1')
				c0++;
			a1[i] = c0;
		}

		a2[S.length() - 1] = 0;
		for (int i = S.length() - 2; i >= 0; i--)
		{
			if (S.charAt(i + 1) == '0')
				c1++;
			a2[i] = c1;
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < a1.length; i++)
		{
			result = Math.min(result, a1[i] + a2[i]);
		}

		for (int i : a1)
			System.out.print(i + "\t");
		// System.out.println("\n");

		for (int i : a2)
			System.out.print(i + "\t");
		// System.out.println("\n");

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		minFlipsMonoIncr("10011111110010111011");
	}

}
