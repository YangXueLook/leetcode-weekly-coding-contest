package lc0316;

import java.util.HashMap;
import java.util.HashSet;

public class Q2
{
	public static int numPairsDivisibleBy60(int[] time)
	{
		int count = 0;
		for (int i = 0; i < time.length; i++)
		{
			time[i] = time[i] % 60;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : time)
		{
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		HashSet<Integer> visited = new HashSet<Integer>();

		for (Integer i : map.keySet())
		{
			System.out.println(i + "   " + map.get(i));
			if (!visited.contains(i))
			{
				if (i == 0 || i == 30)
				{
					if (map.get(i) >= 2)
					{
						int n = map.get(i);
						count += n * (n - 1) / 2;
					}
					visited.add(i);
				}

				else
				{
					int complement = 60 - i;
					if (map.containsKey(complement))
					{
						int n1 = map.get(i);
						int n2 = map.get(complement);
						count += n1 * n2;
						visited.add(i);
						visited.add(complement);
					}
				}
			}

		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(numPairsDivisibleBy60(new int[] { 439, 407, 197,
				191, 291, 486, 30, 307, 11 }));

	}

}
