package lc0330;

public class Q4
{

	public int numEnclaves(int[][] A)
	{
		int result = 0;
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < A.length; j++)
			{
				if (A[i][j] == 1)
				{
					int a = flood(A, i, j);
					if(a > 0)
						System.out.println(i + "  " + j + "\t" + a);
					
					result += a;
				}

			}
		}

		return result;
	}

	private int flood(int[][] A, int i, int j)
	{

		A[i][j] = 0;

		int result = 1;
		int up = -1, down = -1, left = -1, right = -1;

		if (i > 0 && A[i - 1][j] == 1)
		{
			up = flood(A, i - 1, j);
		}

		if (i < A.length - 1 && A[i + 1][j] == 1)
		{
			down = flood(A, i + 1, j);
		}

		if (j > 0 && A[i][j - 1] == 1)
		{
			left = flood(A, i, j - 1);
		}

		if (j < A[0].length - 1 && A[i][j + 1] == 1)
		{
			right = flood(A, i, j + 1);
		}

		if (i == 0 || j == 0 || i == A.length - 1 || j == A[0].length - 1)
			result = 0;
		else if (up == 0 || down == 0 || left == 0 || right == 0)
			result = 0;
		else
		{
			if (up == -1)
				up = 0;
			if (down == -1)
				down = 0;
			if (left == -1)
				left = 0;
			if (right == -1)
				right = 0;

			result = result + up + down + left + right;
		}
		return result;

	}

	public static void main(String[] args)
	{
		Q4 t = new Q4();
		
		
		
		int[][] A = new int[][] { 
				{ 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 },
				{ 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
				{ 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 } };
		
		t.numEnclaves(A);

	}

}
