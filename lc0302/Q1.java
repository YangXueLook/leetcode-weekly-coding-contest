package lc0302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q1
{

	public List<String> commonChars(String[] A)
	{
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : A[0].toCharArray())
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		for (String s : A)
		{
			HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
			for (char c : s.toCharArray())
			{
				if (tempMap.containsKey(c))
					tempMap.put(c, tempMap.get(c) + 1);
				else
					tempMap.put(c, 1);
			}
			
			HashSet<Character> set = new HashSet<Character>();
			for (char c : map.keySet())
			{
				if (!tempMap.containsKey(c))
					set.add(c);
				else
				{
					map.put(c, Math.min(map.get(c), tempMap.get(c)));
				}
			}
			for(char c : set)
				map.remove(c);

		}
		for (char c : map.keySet())
		{
			int time = map.get(c);
			for (int i = 0; i < time; i++)
				result.add(String.valueOf(c));
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
