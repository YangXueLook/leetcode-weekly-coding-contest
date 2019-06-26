/**
 * lookiYang Xue
 * TODO
 * May 25, 2019
 * 2019
 */
package lc0525;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author looki
 * 
 */
public class Q4
{
	public int[] rearrangeBarcodes(int[] barcodes)
	{

		if (barcodes.length == 1)
			return barcodes;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : barcodes)
		{
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(
				new Comparator<Map.Entry<Integer, Integer>>()
				{

					@Override
					public int compare(Entry<Integer, Integer> o1,
							Entry<Integer, Integer> o2)
					{
						return o2.getValue() - o1.getValue();
					}
				});

		q.addAll(map.entrySet());
		int i = 0;
		while (q.size() > 1)
		{
			Entry e1 = q.poll();
			barcodes[i] = (int) e1.getKey();
			i++;
			e1.setValue((Integer) e1.getValue() - 1);

			Entry e2 = q.poll();
			barcodes[i] = (int) e2.getKey();
			i++;
			e2.setValue((Integer) e2.getValue() - 1);

			if ((Integer) e1.getValue() > 0)
				q.offer(e1);

			if ((Integer) e2.getValue() > 0)
				q.offer(e2);
		}

		if (!q.isEmpty())
			barcodes[i] = q.poll().getKey();

		return barcodes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Q4 t = new Q4();
		t.rearrangeBarcodes(new int[] { 1, 1, 1, 2, 2, 2 });

	}

}
