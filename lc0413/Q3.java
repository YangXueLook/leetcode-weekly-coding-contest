package lc0413;

import java.util.Arrays;
import java.util.HashMap;

public class Q3
{

	public int longestArithSeqLength(int[] A)
	{
		int max = 0;
		Arrays.sort(A);
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < A.length; i++)
		{
			int thisMax = 1;
			HashMap<Integer, Integer> myMap = map.get(A[i]);
			if (myMap != null)
			{
				Integer v = myMap.get(0);
				myMap.put(0, v.intValue() + 1);
				continue;
			}
			else
			{
				myMap = new HashMap<Integer, Integer>();
				map.put(A[i], myMap);
				myMap.put(0, 1);
			}
			for (int j = 0; j < i; j++)
			{
				HashMap<Integer, Integer> hisMap = map.get(A[j]);
				int key = A[i] - A[j];
				Integer v = hisMap.get(key);
				if (v != null)
				{
					myMap.put(key, v.intValue() + 1);
				}
				else
				{
					myMap.put(key, 2);
				}
				
				if (myMap.get(key) > thisMax)
				{
					thisMax = myMap.get(key);
				}
			}
			if (thisMax > max)
			{
				max = thisMax;
			}
		}

		return max;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
