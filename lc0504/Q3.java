package lc0504;

import java.util.ArrayList;

public class Q3
{

	public static int minScoreTriangulation(int[] A)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : A)
			list.add(i);
		return helper(list);

	}

	static private int helper(ArrayList<Integer> list)
	{
		if (list.size() == 3)
		{

			return list.get(0) * list.get(1) * list.get(2);
		}

		int pro = Integer.MAX_VALUE;

		int a = -1;
		int b = -1;

		for (int i = 0; i < list.size(); i++)
		{
			for (int j = 0; j < list.size(); j++)
			{
				if (j != i && (i + 1) % list.size() != i
						&& (i - 1 + list.size()) % list.size() != i)
				{
					int p = list.get(i) * list.get(j);
					if (p < pro)
					{
						pro = p;
						a = Math.min(i, j);
						b = Math.max(i, j);
					}

				}
			}
		}
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();

		for (int i = a; i <= b; i++)
			l1.add(list.get(i));

		for (int i = b; i < list.size(); i++)
			l2.add(list.get(i));
		for (int i = 0; i <= a; i++)
			l2.add(list.get(i));
		return helper(l1) + helper(l2);
	}

	public static void main(String[] args)
	{
		System.out.println(minScoreTriangulation(new int[] { 1,3,1,4,1,5 }));

	}

}
