package lc0316;

public class Q1
{

	public static int bitwiseComplement(int N)
	{
		String s = Integer.toBinaryString(N);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '0')
				sb.append(1);
			else
				sb.append(0);
		}

		return Integer.parseInt(sb.toString(), 2);
	}

	public static void main(String[] args)
	{
		System.out.println(bitwiseComplement(5));
		System.out.println(bitwiseComplement(7));
		System.out.println(bitwiseComplement(10));

	}

}
