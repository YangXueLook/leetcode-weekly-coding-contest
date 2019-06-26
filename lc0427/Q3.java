package lc0427;

public class Q3
{
	public int maxUncrossedLines(int[] A, int[] B)
	{
		return helper(A, 0, A.length - 1, B, 0, B.length - 1);

	}

	private int helper(int[] A, int s1, int e1, int[] B, int s2, int e2)
	{
		if (s1 > e1 || s1 < 0 || e1 >= A.length || s2 > e2 || s2 < 0
				|| e2 >= B.length)
			return 0;

		int max = 0;

		for (int i = s1; i <= e1; i++)
		{
			for (int j = s2; j <= e2; j++)
			{
				if (A[i] == B[j])
				{
					max = Math.max(max, helper(A, s1, i - 1, B, s2, j - 1)
							+ helper(A, i + 1, e1, B, j + 1, e2) + 1);
				}

			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		double[] a = new double[10];
		double max = -1;
		for (int i = 0; i < 100; i++)
		{
			double r1 = Math.random() * 50;
			double r2 = Math.random() * 50;
			System.out.println(r1 + "\t" + r2 + "\t" + (r2 + r1));

		}

	}
}
