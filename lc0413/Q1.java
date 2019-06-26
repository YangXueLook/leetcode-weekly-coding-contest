package lc0413;

import java.util.ArrayList;
import java.util.HashSet;

public class Q1
{
	public static boolean divisorGame(int N) {
		HashSet<Integer> A = new HashSet<Integer>();
		HashSet<Integer> B = new HashSet<Integer>();
		A.add(2);
		A.add(5);
		A.add(6);
		B.add(1);
		B.add(3);
		B.add(4);
		for(int i = 7; i <= 1000; i++)
		{
			ArrayList<Integer> list = getFactor(i);
			for(Integer j: list)
			{
				if(A.contains(i - j))
				{
					B.add(i);
					break;
				}
				if(B.contains(i - j))
				{
					A.add(i);
					break;
				}
			}
		}
		
		for(Integer i : A)
			System.out.println("A.add(" + i + ");");
		
		for(Integer i : B)
			System.out.println("B.add(" + i + ");");
		
		
        return true;
    }

	private static ArrayList<Integer> getFactor(int N)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i < N; i++)
		{
			if(N % i == 0)
				list.add(i);
		}

		return list;
	}

	public static void main(String[] args)
	{
		divisorGame(1000);

	}

}
