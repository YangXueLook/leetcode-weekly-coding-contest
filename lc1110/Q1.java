package lc1110;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Q1
{

	public int minAreaRect(int[][] points)
	{
		Arrays.sort(points, new Comparator<int[]>()
		{

			@Override
			public int compare(int[] o1, int[] o2)
			{
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});

		HashSet<Long> set = new HashSet<Long>();
		for (int[] array : points)
		{
			set.add((long) array[0] * 40000 + (long) array[1]);
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++)
			{
				if (points[i][0] < points[j][0] && points[i][1] < points[j][1])
				{
					if (set.contains((long) points[i][0] * 40000
							+ (long) points[j][1])
							&& set.contains((long) points[j][0] * 40000
									+ (long) points[i][1]))
						result = Math.min(result, (points[j][0] - points[i][0])
								* (points[j][1] - points[i][1]));
				}
			}
		}

		return result == Integer.MAX_VALUE ? 0 : result;
	}

	public static void main(String[] args)
	{
		System.out.println(Integer.MAX_VALUE);
	}

}
