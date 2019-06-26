package lc0915;

public class Q1
{

	public int[] sortArrayByParity(int[] A)
	{
		int[] result = new int[A.length];
		int l = 0;
		int r = A.length - 1;

		for (int i : A)
		{
			if (i % 2 == 0)
			{
				result[l] = i;
				l++;
			}
			else
			{
				result[r] = i;
				r--;
			}

		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println("hhh");

	}

}
