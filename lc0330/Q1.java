package lc0330;

import java.util.ArrayList;
import java.util.List;

public class Q1
{
	public List<Boolean> prefixesDivBy5(int[] A)
	{
		List<Boolean> result = new ArrayList<Boolean>();
		int[] mod = new int[A.length];
		mod[0] = A[0];
		for (int i = 1; i < A.length; i++)
		{
			mod[i] = (mod[i - 1] * 2 + A[i]) % 5;
		}
		for (int i : mod)
		{
			if (i == 0)
				result.add(true);
			else
				result.add(false);
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
