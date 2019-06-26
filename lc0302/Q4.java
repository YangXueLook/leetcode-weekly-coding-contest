package lc0302;

import java.util.ArrayList;

public class Q4
{
	public int mergeStones(int[] stones, int K)
	{
		if ((stones.length - 1) % (K - 1) != 0)
			return -1;
		int costSum = 0;

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i : stones)
			list.add(i);
		while (list.size() > 1)
		{
			int index = 0;
			int minSum = Integer.MAX_VALUE;
			int currentSum = 0;
			for (int i = 0; i < K; i++)
				currentSum += list.get(i);
			minSum = currentSum;
			for (int i = K; i < list.size(); i++)
			{
				currentSum = currentSum - list.get(i - K);
				currentSum = currentSum + list.get(i);
				if (currentSum < minSum)
				{
					minSum = currentSum;
					index = i - K + 1;
				}
			}

			costSum += minSum;
			for (int i = 0; i < K - 1; i++)
				list.remove(index);
			list.set(index, minSum);
		}

		return costSum;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
