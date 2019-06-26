package lc0323;

public class Q4
{

	public boolean queryString(String S, int N)
	{
		for (int i = N; i >= 1; i--)
		{
			String s = Integer.toBinaryString(i);
			if (!S.contains(s))
				return false;
		}

		return true;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
