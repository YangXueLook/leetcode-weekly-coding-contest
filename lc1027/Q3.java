package lc1027;

public class Q3
{

	public int minFallingPathSum(int[][] A)
	{
		int result = Integer.MAX_VALUE;
		int[][] m = new int[A.length][A[0].length];
		if (A.length == 1)
			return A[0][0];
		else if (A.length == 2)
			return Math.min(Math.min(A[0][0] + A[1][0], A[0][0] + A[1][1]),
					Math.min(A[0][1] + A[1][0], A[0][1] + A[1][1]));

		for (int i = 0; i < A[0].length; i++)
			m[0][i] = A[0][i];
		for (int i = 1; i < A.length; i++)
		{
			for (int j = 0; j < A[0].length; j++)
			{
				if (j == 0)
				{
					m[i][j] = A[i][j] + Math.min(m[i - 1][j], m[i - 1][j + 1]);
					
				}
				else if (j == A[0].length - 1)
				{
					m[i][j] = A[i][j] + Math.min(m[i - 1][j], m[i - 1][j - 1]);
					
				}
				else
				{
					m[i][j] = A[i][j]
							+ Math.min(Math.min(m[i - 1][j], m[i - 1][j - 1]),
									m[i - 1][j + 1]);
					
				}
			}
		}
		
		for(int i : m[A.length - 1])
			result = Math.min(result, i);
		
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
