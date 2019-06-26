package lc0406;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Q3
{

	public List<Boolean> camelMatch(String[] queries, String pattern)
	{
		List<Boolean> result = new ArrayList<Boolean>();
		for (String s : queries)
		{
			if (isMatched(s, pattern))
				result.add(true);
			else
				result.add(false);
		}

		return result;
	}
	
	private boolean isMatched(String s, String pattern)
	{
		StringBuffer sb = new StringBuffer();
		for(char c: pattern.toCharArray())
		{
			sb.append("[a-z]*").append(c);
		}
		sb.append("[a-z]*");
		
		
		return Pattern.matches(sb.toString(), s);
	}

//	private boolean isMatched(String s, String pattern)
//	{
//		ArrayList<Integer> l1 = new ArrayList<Integer>();
//		for (int i = 0; i < pattern.length(); i++)
//		{
//			if (pattern.charAt(i) >= 'A' && pattern.charAt(i) <= 'Z')
//				l1.add(i);
//		}
//
//		ArrayList<Integer> l2 = new ArrayList<Integer>();
//		for (int i = 0; i < s.length(); i++)
//		{
//			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
//				l2.add(i);
//		}
//
//		for (Integer i : l1)
//			System.out.print(i + "\t");
//		System.out.println();
//
//		for (Integer i : l2)
//			System.out.print(i + "\t");
//		System.out.println();
//
//		if (l1.size() == 0 && l2.size() > 0)
//			return false;
//		else if(l1.size() == 0 && l2.size() == 0)
//            return contains( s,  pattern);
//		
//		else if (l1.size() > l2.size())
//			return false;
//		else
//		{
//			if (l1.get(0) == 0)
//			{
//
//				if (l2.size() != l1.size())
//					return false;
//
//				for (int i = 0; i < l1.size(); i++)
//				{
//					String p1;
//					String s1;
//					if (i != l1.size() - 1)
//					{
//						p1 = pattern.substring(l1.get(i), l1.get(i + 1));
//						s1 = s.substring(l2.get(i), l2.get(i + 1));
//					}
//
//					else
//					{
//						p1 = pattern.substring(l1.get(i));
//						s1 = s.substring(l2.get(i));
//					}
//
//					System.out.println(p1 + "\t" + s1);
//
//					if (p1.charAt(0) != s1.charAt(0))
//					{
//						System.out.println("111111");
//						return false;
//					}
//
//					if (!contains(s1.substring(1), p1.substring(1)))
//					{
//						System.out.println("22222");
//						return false;
//					}
//
//				}
//
//			}
//			else
//			{
//				if (l2.get(0) == 0)
//					return false;
//				String prefix1 = pattern.substring(0, l1.get(0));
//				String prefix2 = s.substring(0, l2.get(0));
//				if (!contains(prefix2, prefix1))
//					return false;
//
//				for (int i = 1; i < l1.size(); i++)
//				{
//					String p1;
//					String s1;
//					if (i != l1.size() - 1)
//					{
//						p1 = pattern.substring(l1.get(i), l1.get(i + 1));
//						s1 = s.substring(l2.get(i), l2.get(i + 1));
//					}
//
//					else
//					{
//						p1 = pattern.substring(l1.get(i));
//						s1 = s.substring(l2.get(i));
//					}
//
//					if (p1.charAt(0) != s1.charAt(0))
//						return false;
//					if (!contains(s1.substring(1), p1.substring(1)))
//						return false;
//
//				}
//
//			}
//
//		}
//
//		return true;
//	}

	// ["uAxaqlzahfialcezsLfj","cAqlzyahaslccezssLfj","AqlezahjarflcezshLfj","AqlzofahaplcejuzsLfj","tAqlzahavslcezsLwzfj","AqlzahalcerrzsLpfonj","AqlzahalceaczdsosLfj","eAqlzbxahalcezelsLfj"]
	// "AqlzahalcezsLfj"
	private boolean contains(String s2, String s1)
	{
		int i1 = 0;
		int i2 = 0;
		while (i1 < s1.length())
		{
			if (i2 >= s2.length())
				return false;
			char c = s1.charAt(i1);
			while (s2.charAt(i2) != c)
			{
				i2++;
				if (i2 >= s2.length())
					return false;
			}
			i1++;
			i2++;
		}

		return true;
	}

	public static void main(String[] args)
	{
		Q3 t = new Q3();
		System.out.println(t.isMatched("uAxaqlzahfialcezsLfj",
				"AqlzahalcezsLfj"));

	}

}
