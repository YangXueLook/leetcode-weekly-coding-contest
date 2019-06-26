/**
 * lookiYang Xue
 * TODO
 * Jun 22, 2019
 * 2019
 */
package lc0622;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author looki
 * 
 */
public class Q2
{

	class Pair
	{
		int i;
		int cap;

		Pair(int i, int cap)
		{
			this.i = i;
			this.cap = cap;
		}
	}

	public boolean carPooling(int[][] trips, int capacity)
	{
		ArrayList<Pair> list = new ArrayList<Pair>();

		for (int[] t : trips)
		{
			list.add(new Pair(t[1], t[0]));
			list.add(new Pair(t[2], -t[0]));
		}
		Collections.sort(list, new Comparator<Pair>()
		{
			public int compare(Pair o1, Pair o2)
			{
				// TODO Auto-generated method stub
				if (o1.i == o2.i)
					return o1.cap - o2.cap;
				else
					return o1.i - o2.i;
			}
		});

		int currentCap = 0;

		for (Pair p : list)
		{
			currentCap += p.cap;
			if (currentCap > capacity)
				return false;
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
//		[[3,2,7],[3,7,9],[8,3,9]]
//				11
		Q2 t =  new Q2();
		System.out.print(t.carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));

	}

}
