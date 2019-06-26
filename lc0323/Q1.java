package lc0323;

public class Q1
{

	public boolean canThreePartsEqualSum(int[] A)
	{
		int sum = 0;
		for (int i : A)
			sum += i;
		if (sum % 3 != 0)
			return false;

		int target = sum / 3;
		sum = 0;
		int part = 0;
		for (int i : A)
		{
			sum += i;
			if (sum == target)
			{
				sum = 0;
				part++;
			}
		}

		return sum == 0 && part == 3;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
