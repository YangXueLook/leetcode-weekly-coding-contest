package lc0330;

import java.util.ArrayList;
import java.util.List;

public class Q2
{

	static String baseNeg2(int N)
	{
		StringBuffer result = new StringBuffer();
		if (N == 0)
			return "0";

		while (true)
		{
			if (N == 1)
			{
				result.append(Math.abs(N) % 2);
				break;
			}
			if (Math.abs(N) % 2 != 0)
			{
				result.append(1);
				N = (N - 1) / (-2);
			}
			else
			{
				result.append("0");
				N = N / (-2);
			}

		}

		return result.reverse().toString();
	}

	// int[] mod(int a, int b, int n)
	// {
	// if(a < 0 && a%b != 0){
	// n = a / b + 1;
	// return a - (a / b + 1) * b;//返回非负余数
	// }
	// n = a / b;
	// int[] result = new int[2];
	// result[0] = a % b;
	// result[1] = n;
	//
	// return result;
	// }

	// public String baseNeg2(int N)
	// {
	// List<Integer> list = new ArrayList<Integer>();
	//
	// while(N != 0)
	//
	// {
	// int[] array =
	// }
	// list.add(mod(N,-2, N));
	//
	// for(Integer i : list )
	// System.out.println(i);
	//
	// StringBuffer result = new StringBuffer();
	//
	// return result.toString();
	// }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Q2 t = new Q2();
		System.out.println(t.baseNeg2(2));
		System.out.println(t.baseNeg2(3));
		System.out.println(t.baseNeg2(4));
	}

}
