package lc0323;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Q3
{

	public int maxScoreSightseeingPair(int[] A)
	{
		int result = A[0] + A[1] - 1;
		int currentMax = Math.max(A[0] - 1, A[1]);
		for (int i = 2; i < A.length; i++)
		{
			result = Math.max(result, A[i] + currentMax - 1);
			currentMax = Math.max(currentMax - 1, A[i]);
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] a = new int[] { 8, 1, 5, 2, 6 };
		Arrays.sort(a, new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2)
			{
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});

	}

}
