package lc0430;

public class Q3
{
	public static int maxSumTwoNoOverlap(int[] A, int L, int M)
	{
		int[] la = new int[A.length];
		int[] ma = new int[A.length];

		int lsum = 0;
		for (int i = 0; i < L; i++)
			lsum += A[i];
		la[0] = lsum;

		for (int i = 1; i + L - 1 < A.length; i++)
		{
			lsum = lsum + A[i - 1 + L] - A[i - 1];
			la[i] = lsum;
		}

		for (int i : la)
			System.out.print(i + "\t");
		System.out.println();

		int msum = 0;
		for (int i = 0; i < M; i++)
			msum += A[i];
		ma[0] = msum;

		for (int i = 1; i + M - 1 < A.length; i++)
		{
			msum = msum + A[i - 1 + M] - A[i - 1];
			ma[i] = msum;
		}

		for (int i : ma)
			System.out.print(i + "\t");
		System.out.println();

		int result = -1;
//		&& ((j > i + L - 1) || (i > j + M - 1))
		for (int i = 0; i + L - 1 < la.length; i++)
		{
			System.out.println(i + "---------");
			for (int j = 0; j + M - 1 < ma.length; j++)
			{
				if((j > i + L - 1) || (i > j + M - 1))
				{
					result = Math.max(result, la[i] + ma[j]);
				}
				
				System.out.println((j > i + L - 1) + " ++ " + (i > j + M - 1));
				
				System.out.println(la[i] + ma[j] + "\t" + i + "\t" + j);

				
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(maxSumTwoNoOverlap(new int[] { 8, 20, 6, 2, 20, 17,
				6, 3, 20, 8, 12 }, 5, 4));

	}

}
