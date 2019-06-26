package lc0105;

import java.util.ArrayList;
import java.util.List;

public class Q2
{

	public List<Integer> pancakeSort(int[] A)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = A.length - 1; i >= 0; i--)
		{
			int[] a = oneStep(A, i);
			result.add(a[0]);
			result.add(a[1]);
		}
		
		return result;
	}

	private int[] oneStep(int[] a, int bound)
	{
		int[] result = new int[2];
		int max = a[0];
		int index = 0;
		for(int i = 1; i <= bound; i++)
		{
			if(a[i] > max)
			{
				max = a[i];
				index = i;
			}
		}
		
		
		return null;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
