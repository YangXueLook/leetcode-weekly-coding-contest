package lc1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q3
{
	public String[] reorderLogFiles(String[] logs)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (String log : logs)
		{
			String s = log.split(" ")[1];
			char c = s.charAt(0);
			if (c >= '0' && c <= '9')
				list.add(log);
		}

		Arrays.sort(logs, new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2)
			{
				String[] a1 = o1.split(" ");
				String[] a2 = o2.split(" ");
				String id1 = a1[0];
				String id2 = a2[0];

				int index1 = o1.indexOf(" ");
				int index2 = o2.indexOf(" ");
				if (o1.charAt(index1 + 1) >= '0'
						&& o1.charAt(index1 + 1) <= '9')
					return -1;
				if (o2.charAt(index2 + 1) >= '0'
						&& o2.charAt(index2 + 1) <= '9')
					return 1;

				if (!o1.substring(index1 + 1).equals(o2.substring(index2 + 1)))
					return o1.substring(index1 + 1).compareTo(
							o2.substring(index2 + 1));
				else
					return id1.compareTo(id2);
			}
		});

		int start = logs.length - list.size();
		for (int i = start; i < logs.length; i++)
			logs[i] = list.get(i - start);

		return logs;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
