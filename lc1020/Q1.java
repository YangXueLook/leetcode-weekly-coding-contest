package lc1020;

import java.util.ArrayList;

public class Q1
{

	public static boolean isLongPressedName(String name, String typed)
	{
		ArrayList<Integer> l1 = helper(name);
		ArrayList<Integer> l2 = helper(typed);

		if (l1.size() != l2.size())
			return false;
		for (int i = 0; i < l1.size(); i++)
		{
			System.out.println(l1.get(i) + "  " + l2.get(i));
			if (l1.get(i) > l2.get(i))
				return false;
		}

		return true;
	}

	private static ArrayList<Integer> helper(String s)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		char current = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++)
		{
			if (i != s.length() - 1)
			{
				if (s.charAt(i) == current)
				{
					count++;
				}
				else
				{
					list.add(count);
					count = 1;
					current = s.charAt(i);
				}
			}
			else
			{
				if (s.charAt(i) == current)
				{
					count++;
					list.add(count);
				}
				else
				{
					list.add(count);
					list.add(1);
				}
			}
		}

		System.out.println(list.size());
		return list;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		isLongPressedName("alex", "aaleex");
	}

}
