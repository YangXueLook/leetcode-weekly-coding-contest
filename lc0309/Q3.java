package lc0309;

public class Q3
{
	public int minDominoRotations(int[] A, int[] B)
	{
		int result = 20000 + 1;

		for (int i = 1; i <= 6; i++)
		{
			result = Math.min(result, helper(i, A, B));
		}

		return result > A.length? - 1 : result;
	}

	private int helper(int target, int[] A, int[] B)
	{
		int resultA = 0;
		int resultB = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == target)
				resultA += 0;
			else if (B[i] == target)
				resultA += 1;
			else
			{
				resultA = Integer.MAX_VALUE;
				break;
			}
		}
		for (int i = 0; i < B.length; i++)
		{
			if (B[i] == target)
				resultB += 0;
			else if (A[i] == target)
				resultB += 1;
			else
			{
				resultB = Integer.MAX_VALUE;
				break;
			}
		}

		return Math.min(resultA, resultB);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
