/**
 * lookiYang Xue
 * TODO
 * Jun 15, 2019
 * 2019
 */
package lc0615;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author looki
 * 
 */
public class Q2
{
	class Pair
	{
		int val;
		int label;

		Pair(int val, int label)
		{
			this.val = val;
			this.label = label;
		}
	}

	public int largestValsFromLabels(int[] values, int[] labels,
			int num_wanted, int use_limit)
	{
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < values.length; i++)
		{
			list.add(new Pair(values[i], labels[i]));
		}

		Collections.sort(list, new Comparator<Pair>()
		{

			@Override
			public int compare(Pair o1, Pair o2)
			{
				// TODO Auto-generated method stub
				return o2.val - o1.val;
			}

		});
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int i = 0;
		while (num_wanted > 0 && i < list.size())
		{
			int label = list.get(i).label;
			if (!map.containsKey(label))
			{
				map.put(label, 1);
				sum += list.get(i).val;
				i++;
				num_wanted--;
			}
			else
			{
				if (map.get(label) < use_limit)
				{
					map.put(label, map.get(label) + 1);
					sum += list.get(i).val;
					i++;
					num_wanted--;
				}
				else
					i++;
			}
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
