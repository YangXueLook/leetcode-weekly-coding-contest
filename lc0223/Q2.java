package lc0223;

public class Q2
{

	public int numRookCaptures(char[][] board)
	{
		int x = -1;
		int y = -1;

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 'R')
				{
					x = i;
					y = j;
					i = board.length;
					j = board[0].length;
				}
			}
		}

		int count = 0;
		for (int i = x; i < board.length; i++)
		{
			if (board[i][y] == 'p')
			{
				count++;
				break;
			}
			else if (board[i][y] == 'B')
				break;
		}

		for (int i = x; i >= 0; i--)
		{
			if (board[i][y] == 'p')
			{
				count++;
				break;
			}
			else if (board[i][y] == 'B')
				break;
		}

		for (int i = y; i < board[0].length; i++)
		{
			if (board[x][i] == 'p')
			{
				count++;
				break;
			}
			else if (board[x][i] == 'B')
				break;
		}

		for (int i = y; i >= 0; i--)
		{
			if (board[x][i] == 'p')
			{
				count++;
				break;
			}
			else if (board[x][i] == 'B')
				break;
		}

		return count;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
