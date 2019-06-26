package lc1215;

import java.util.HashSet;

public class Q2
{
	public int[] prisonAfterNDays(int[] cells, int N)
	{
		if (N == 0)
			return cells;
		if (N == 1)
			return oneChange(cells);
		
		cells = oneChange(cells);
		N--;
		int repeatLength = getLength(cells);
		N = N % repeatLength;
		for(int i = 0; i < N; i++)
			cells = oneChange(cells);
		
		return cells;
	}

	private int getLength(int[] cells)
	{
		int distance = 1;
		HashSet<String> set = new HashSet<String>();
		set.add(parser(cells));
		
		boolean found = false;

		for (int i = 0; i < 100000; i++)
		{
			cells = oneChange(cells);
			String s = parser(cells);
			
			if (set.contains(s))
			{
				
				found = true;
				return distance;
			}
			else
			{
				set.add(s);
				distance++;
			}

		}
		
		return -1;
	}

	private int[] oneChange(int[] A)
	{
		int[] B = new int[8];
		B[0] = 0;
		B[7] = 0;
		for (int i = 1; i < 7; i++)
		{
			if (A[i - 1] == A[i + 1])
				B[i] = 1;
			else
				B[i] = 0;
		}
		return B;
	}

	private String parser(int[] A)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < 7; i++)
			sb.append(A[i]);
		return  "0" + sb.toString() + "0";
	}

	public static void main(String[] args)
	{
		int[] A = new int[]{1,0,0,1,0,0,1,0};
		int[] B = new Q2().prisonAfterNDays(A, 1000000000);
		for(int i: B)
			System.out.print(i + ", ");
	}

}
