package lc1027;

import java.util.HashMap;
import java.util.Map;

public class Q2
{
	public int numSubarraysWithSum(int[] A, int S)
	{
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < A.length; i++)
		{
			sum += A[i];
			if (preSum.containsKey(sum - S))
			{
				result += preSum.get(sum - S);
			}
			if (preSum.containsKey(sum))
				preSum.put(sum, preSum.get(sum) + 1);
			else
				preSum.put(sum, 0);

		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
