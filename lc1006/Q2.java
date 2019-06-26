package lc1006;

public class Q2
{
	

	// The first is that the subarray take only a middle part, and we know how
	// to find the max subarray sum.
	
	// The second is that the subarray take a part of head array and a part of
	// tail array.
	
	// We can transfer this case to the first one.
	// The maximum result equals to the total sum minus the minimum subarray
	// sum.


	public int maxSubarraySumCircular(int[] A)
	{
		int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
		for (int a : A)
		{
			curMax = Math.max(curMax + a, a);
			maxSum = Math.max(maxSum, curMax);
			curMin = Math.min(curMin + a, a);
			minSum = Math.min(minSum, curMin);
			total += a;
		}
		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
