package lc0430;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lc0430.Q1.Pair;

public class Q2
{
	static class Pair
	{
		int a;
		int diff;

		Pair(int a, int diff)
		{
			this.a = a;
			this.diff = diff;
		}

	}

	public int twoCitySchedCost(int[][] costs)
	{
		int result = 0;
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int[] pair : costs)
		{
			list.add(new Pair(pair[0], pair[1] - pair[0]));
		}

		Collections.sort(list, new Comparator<Pair>()
		{

			@Override
			public int compare(Pair o1, Pair o2)
			{
				// TODO Auto-generated method stub
				return o1.diff - o2.diff;
			}

		});
		for (int i = 0; i < costs.length / 2; i++)
		{
			result += list.get(i).a + list.get(i).diff;
		}
		for (int i = costs.length / 2; i < costs.length; i++)
		{
			result += list.get(i).a;
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
