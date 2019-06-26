/**
 * lookiYang Xue
 * TODO
 * Jun 15, 2019
 * 2019
 */
package lc0615;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author looki
 * 
 */
public class Q3
{
	public static int shortestPathBinaryMatrix(int[][] grid)
	{
//		if (grid.length == 2 && grid[0][0] == 0 && grid[1][1] == 0
//				& grid[1][0] == 1 && grid[0][1] == 1)
//			return 2;

		int len = grid.length;

		if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1)
			return -1;

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
				if (grid[i][j] == 1)
					grid[i][j] = -1;
		}

		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0 });
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(0);

		while (!q.isEmpty())
		{
			int size = q.size();
			for (int i = 0; i < size; i++)
			{
				int[] head = q.poll();
				int x = head[0];
				int y = head[1];

				int distance = grid[x][y];
				// visited.add(x * 100 + y);
				if (x == len - 1 && y == len - 1)
				{
					for (int a = 0; a < len; a++)
					{
						for (int b = 0; b < len; b++)
						{
							System.out.print(grid[a][b] + "\t");
						}
						System.out.println();
					}
					return distance + 1;
				}
					

				for (int m = -1; m <= 1; m++)
				{
					for (int n = -1; n <= 1; n++)
					{
						int x1 = x + m;
						int y1 = y + n;
						if (x1 >= 0 && x1 < len && y1 >= 0 && y1 < len
								&& !visited.contains(x1 * 100 + y1) && grid[x1][y1] != -1)
						{
							grid[x1][y1] = distance + 1;
							visited.add(x1 * 100 + y1);
							q.offer(new int[] { x1, y1 });
						}

					}
				}

			}

		}

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 },
				{ 1, 1, 0 } });

	}

}
