package lc0302;

public class Q3
{

	public int longestOnes(int[] A, int K)
	{
		int p1 = 0, p2 = 0;
		int max = -1;
		int currentZero = A[0] == 0 ? 1 : 0;
		while (p1 < A.length && p2 < A.length)
		{
			while (currentZero <= K)
			{
				p2++;
				if(p2 == A.length)
				{
					max = Math.max(max, p2 - p1);
					return max;
				}
				
				if (A[p2] == 0)
					currentZero++;
			}
			max = Math.max(max, p2 - p1);
			while (currentZero > K)
			{
				if (A[p1] == 0)
					currentZero--;
				p1++;
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
