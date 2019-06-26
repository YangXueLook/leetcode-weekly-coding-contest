package lc1201;

import java.util.ArrayList;

public class Q1
{

	public String largestTimeFromDigits(int[] A)
	{

		int[] currentMax = new int[4];
		currentMax[3] = -1;

		permutation(currentMax, A, 0, 3);

		if (currentMax[3] == -1)
			return "";
		else
		{
			StringBuffer result = new StringBuffer();
			return result.append(currentMax[0]).append(currentMax[1])
					.append(":").append(currentMax[2]).append(currentMax[3])
					.toString();
		}

	}

	public void permutation(int[] currentMax, int[] array, int from, int to)
	{
		if (to <= 1)
			return;
		if (from == to)
		{
			int[] result = max(currentMax, array);
			for (int i = 0; i < 4; i++)
				currentMax[i] = result[i];

		}
		else
		{
			for (int i = from; i <= to; i++)

			{
				swap(array, i, from);

				permutation(currentMax, array, from + 1, to);
				swap(array, from, i);

			}
		}
	}

	private int[] max(int[] currentMax, int[] a)
	{
		if (!isValid(a))
		{
			// System.out.println("-----------");
			return currentMax;
		}

		else if (currentMax[0] * 10 + currentMax[1] > a[0] * 10 + a[1])
			return currentMax;
		else if (currentMax[0] * 10 + currentMax[1] < a[0] * 10 + a[1])
			return a;
		else
		{
			if (currentMax[2] * 10 + currentMax[3] >= a[2] * 10 + a[3])
				return currentMax;
			else
				return a;
		}

	}

	private boolean isValid(int[] a)
	{
		return !(a[0] > 2 || a[0] * 10 + a[1] > 23 || a[2] > 5 || a[2] * 10
				+ a[3] > 59);

	}

	public void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Q1 t = new Q1();
		t.largestTimeFromDigits(new int[] { 1, 2, 3, 4 });
	}

}
