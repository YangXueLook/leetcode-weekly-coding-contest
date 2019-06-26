/**
 * lookiYang Xue
 * TODO
 * May 22, 2019
 * 2019
 */
package lc0518;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author looki
 * 
 */
public class Q1
{
	public int lastStoneWeight(int[] stones)
	{
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(
				new Comparator<Integer>()
				{

					@Override
					public int compare(Integer o1, Integer o2)
					{
						// TODO Auto-generated method stub
						return o2 - o1;
					}

				})
		{
		};
		for (int s : stones)
			q.add(s);

		while (q.size() > 1)
		{
			int x = q.poll();
			int y = q.poll();
			q.add(Math.abs(x - y));
		}

		return q.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
