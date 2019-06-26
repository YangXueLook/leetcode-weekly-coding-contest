package lc1027;

import java.util.HashSet;

public class Q1
{

	public int numUniqueEmails(String[] emails)
	{
		HashSet<String> set = new HashSet<String>();
		for (String s : emails)
		{
			String[] array = s.split("@");
			String l = array[0];
			String d = array[1];
			l = l.replace(".", "");
			int index = l.indexOf('+');
			if (index > 0)
				l = l.substring(0, index);
			set.add(l + d);
		}

		return set.size();
	}

	public static void main(String[] args)
	{
		String s = "1.36";
		System.out.println(s.replace(".", ""));

	}

}
