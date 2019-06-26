package lc1013;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Q3
{
	public static int threeSumMulti(int[] A, int target)
	{
		int MOD = (int) (1e9 + 7);
		// HashSet<String> set = new HashSet<String>();
		HashSet<Integer> set = new HashSet<Integer>();
		Arrays.sort(A);
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		for (int i : A)
		{
			if (map.containsKey(i))
				map.put(i, (long) (map.get(i) + 1));
			else
				map.put(i, (long) 1);
		}
		long result = 0;
		for (int i = 0; i < A.length; i++)
		{
			for (int j = i + 1; j < A.length; j++)
			{
				int left = target - A[i] - A[j];
				if (left >= A[j] && map.containsKey(left))
				{
					int xor = (A[i] << 16) ^ (A[j] << 8) ^ (left);

					if (!set.contains(xor))
					{
						set.add(xor);

						if (left == A[i] && left == A[j])
						{
							long count = map.get(left);
							if (count >= 3)
							{
								result = (result + (count - 2) % MOD
										* (count - 1) * count / 6)
										% MOD;

							}
						}
						else if (A[i] == A[j])
						{
							if (map.containsKey(left))
							{
								long count1 = map.get(A[i]);
								long count2 = map.get(left);
								result = (result + count2 * (count1 - 1)
										* count1 / 2)
										% MOD;
							}
						}

						else if (left == A[i])
						{
							long count1 = map.get(A[i]);
							long count2 = map.get(A[j]);
							if (count1 >= 2)
							{
								result = (result + count2 * (count1 - 1)
										* count1 / 2)
										% MOD;

							}
						}
						else if (left == A[j])
						{
							long count1 = map.get(A[j]);
							long count2 = map.get(A[i]);
							if (count1 >= 2)
							{
								result = (result + count2 * (count1 - 1)
										* count1 / 2)
										% MOD;

							}
						}
						else if (map.containsKey(left))
						{
							long count1 = map.get(A[j]);
							long count2 = map.get(A[i]);
							long count3 = map.get(left);
							result = (result + count3 * count2 * count1) % MOD;

						}
					}
				}
			}
		}

		return (int) result;
	}

	public static void main(String[] args)
	{
		long result = ((3000 * 2999 * 2998) / 6) % (int) (1e9 + 7);
		System.out.println(result);

		// threeSumMulti(new int[] { 1,1,2,2,2,2 }, 5);

	}
}
