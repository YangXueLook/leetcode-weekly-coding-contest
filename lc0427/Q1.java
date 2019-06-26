package lc0427;

import java.util.Arrays;

public class Q1
{
	public int[] numMovesStones(int a, int b, int c)
	{
		int result[] = new int[2];
		int[] array = new int[] { a, b, c };
		Arrays.sort(array);
		int p1 = array[1] - array[0];
		int p2 = array[2] - array[1];
		int min;
		if(p1 == 1 && p2 == 1)
			min = 0;
		else if(p1 == 2 || p2 == 2)
			min = 1;
		else min  = 2;
		
		

		int max1 = p1 - 1;
		int max2 = p2 - 1;
		result[0] =min;
		result[1] = max1 + max2;

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
