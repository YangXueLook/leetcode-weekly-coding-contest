package lc0430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Q1
{
	static class Pair
	{
		int x;
		int y;
		int r0;
		int c0;

		Pair(int x, int y, int r0, int c0)
		{
			this.x = x;
			this.y = y;
			this.r0 = r0;
			this.c0 = c0;
		}
	}

	public int[][] allCellsDistOrder(int R, int C, int r0, int c0)
	{
		int[][] result = new int[R * C][2];
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
				list.add(new Pair(i, j, r0, c0));
		}
		Collections.sort(list, new Comparator<Pair>()
		{

			@Override
			public int compare(Pair o1, Pair o2)
			{
				// TODO Auto-generated method stub
				return Math.abs(o1.x - o1.r0) + Math.abs(o1.y - o1.c0)
						- Math.abs(o2.x - o2.r0) - Math.abs(o2.y - o2.c0);
			}

		});
		for (int i = 0; i < list.size(); i++)
		{
			result[i][0] = list.get(i).x;
			result[i][1] = list.get(i).y;
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
