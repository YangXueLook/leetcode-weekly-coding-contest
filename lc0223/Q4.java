package lc0223;

import java.util.HashSet;

public class Q4
{

	public int[] gridIllumination(int N, int[][] lamps, int[][] queries)
	{
		HashSet<Long> set = new HashSet<Long>();

		int[] result = new int[queries.length];
		int[][] board = new int[N][N];
		for (int[] pair : lamps)
		{
			helper(board, pair[0], pair[1], 1);
			set.add((long) pair[0] * 20000 + (long) pair[1]);
		}
		for (int i = 0; i < queries.length; i++)
		{
			int x = queries[i][0];
			int y = queries[i][1];

			long key = (long) x * 20000 + (long) y;
			if (set.contains(key))
			{
				result[i] = 1;
				set.remove(key);
				helper(board, x, y, -1);
			}
			else if (board[x][y] > 0)
			{
				result[i] = 1;
			}
			else
			{
				result[i] = 0;
			}
			int[] direction = new int[] { -1, 0, 1 };
			for (int m : direction)
			{
				for (int n : direction)
				{
					if (!(m == 0 && m == 0))
					{
						int x1 = m + x;
						int y1 = n + y;

						long newKey = (long) x1 * 20000 + (long) y1;
						if (set.contains(newKey))
						{

							set.remove(newKey);
							helper(board, x1, y1, -1);
						}
					}

				}
			}

		}

		return result;
	}

	private void helper(int[][] board, int x, int y, int val)
	{
		for (int i = 0; i < board.length; i++)
		{
			board[x][i] += val;
		}
		for (int i = 0; i < board[0].length; i++)
		{
			board[i][y] += val;
		}

		if (x <= y)
		{
			int dif = y - x;
			for (int i = 0; i + dif < board[0].length; i++)
			{
				board[i][i + dif] += val;
			}

		}
		else
		{
			int dif = x - y;
			for (int i = 0; i + dif < board.length; i++)
			{
				board[i + dif][i] += val;
			}

		}

		int sum = x + y;
		for (int i = 0; i < board.length; i++)
		{
			int j = sum - i;
			if (j >= 0 && j < board[0].length)
			{
				board[i][j] += val;
			}
		}

		board[x][y] -= 3 * val;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
