package lc0309;

import java.util.Arrays;

public class Q1
{
	public static int largestSumAfterKNegations(int[] A, int K)
	{
		Arrays.sort(A);

		int negativeCounter = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] < 0)
				negativeCounter++;
			else
				break;
		}

		int sum = 0;
		if (negativeCounter == K)
		{
			for (int i : A)
				sum += Math.abs(i);
		}
		else if (negativeCounter > K)
		{
			for (int i = 0; i < K; i++)
			{
				sum += Math.abs(A[i]);
			}
			for (int i = K; i < A.length; i++)
			{
				sum += A[i];
			}
		}
		else
		{
			if ((K - negativeCounter) % 2 == 0)
			{
				for (int i : A)
					sum += Math.abs(i);
			}
			else
			{
				int minCost;
				if(negativeCounter == 0)
					minCost = A[0];
				else if (negativeCounter == A.length)
				{
					minCost = Math.abs(A[A.length - 1]);
				}
				else
				{
					minCost = Math.min(Math.abs(A[negativeCounter - 1]),
							Math.abs(A[negativeCounter]));
				}
				for (int i : A)
					sum += Math.abs(i);

				sum -= 2 * minCost;

			}
		}

		return sum;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(largestSumAfterKNegations(new int[]{1}, 11));
	}

}
