package lc0105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q1
{
	public static List<Integer> powerfulIntegers(int x, int y, int bound)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int p = (int) (Math.log(bound) / Math.log(x)) + 1;
		int q = (int) (Math.log(bound) / Math.log(y)) + 1;

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i <= p; i++)
		{
			for (int j = 0; j <= q; j++)
			{
				int sum = (int) Math.pow(x, i) + (int) Math.pow(y, j);
				if (sum <= bound)
					set.add(sum);
			}
		}
		result.addAll(set);
		
		return result;
	}

	private static boolean isValid(int x, int y, int i)
	{

		System.out.println(x + " " + y + " " + i);
		for (int p = 0; p < i; p++)
		{
			int first = (int) Math.pow(x, p);
			if (first >= i)
				return false;

			System.out.println("first " + first);
			int left = i - first;
			int q = (int) (Math.log(left) / Math.log(y));
			System.out.println("q " + q);
			if ((int) Math.pow(y, q) == left)
				return true;
		}

		return false;
	}

	public static void main(String[] args)
	{
		powerfulIntegers(3, 5, 15);

	}

}
