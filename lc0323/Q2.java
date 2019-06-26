package lc0323;

public class Q2
{

	// 1 3 7 9

	public int smallestRepunitDivByK(int K)
	{
		if (K % 2 == 0 || K % 5 == 0)
			return -1;

		int result = 1;
		int current = 1;
		while (result <= K)
		{
			if (current % K == 0)
				return result;
			else
			{
				result++;
				current = (current % K) * 10 + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
