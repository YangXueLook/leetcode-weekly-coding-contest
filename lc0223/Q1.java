package lc0223;

import java.util.HashMap;
import java.util.HashSet;

public class Q1
{

	public int findJudge(int N, int[][] trust)
	{
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 1; i <= N; i++)
			map.put(i, new HashSet<Integer>());

		for (int[] pair : trust)
		{
			if (map.containsKey(pair[0]))
				map.remove(pair[0]);
			if (map.containsKey(pair[1]))
				map.get(pair[1]).add(pair[0]);
		}

		if (map.size() != 1)
			return -1;
		for (Integer i : map.keySet())
		{
			if (map.get(i).size() != N - 1)
				return -1;
			else
				return i;
		}

		return -1;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
