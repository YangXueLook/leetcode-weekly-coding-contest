package lc1013;

public class Q1
{
	public int[] sortArrayByParityII(int[] A)
	{
		int[] result = new int[A.length];
		int o = 1;
		int e = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] % 2 == 0)
			{
				result[e] = A[i];
				e += 2;
			}
			else
			{
				result[o] = A[i];
				o += 2;
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
