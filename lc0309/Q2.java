package lc0309;

public class Q2
{

	public int clumsy(int N)
	{
		// */+-
		if (N == 4)
			return 7;
		else if (N == 3)
			return 6;
		else if (N == 2 || N == 1)
			return N;

		int sum = N * (N - 1) / (N - 2) + (N - 3);

		int i = N - 4;
		while (i >= 4)
		{
			sum -= i * (i - 1) / (i - 2);
			sum += (i - 3);
			i -= 4;
		}

		if (i == 3)
			sum -= 6;
		else if (i == 2)
			sum -= 2;
		else if (i == 1)
			sum -= 1;

		return sum;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
