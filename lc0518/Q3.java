/**
 * lookiYang Xue
 * TODO
 * May 22, 2019
 * 2019
 */
package lc0518;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author looki
 * 
 */
public class Q3
{
	class Node
	{
		public String s;
		public HashSet<Node> children = new HashSet<Node>();
		public int incoming = 0;
		public int length = -1;

		Node(String s)
		{
			this.s = s;
		}

	}

	public int longestStrChain(String[] words)
	{
		Node[] array = new Node[words.length];

		for (int i = 0; i < words.length; i++)
			array[i] = new Node(words[i]);

		for (int i = 0; i < array.length; i++)
		{
			for (int j = i + 1; j < array.length; j++)
			{
				if (isPre(array[i], array[j]))
				{
					array[i].children.add(array[j]);
					array[j].incoming++;
				}
				else if (isPre(array[j], array[i]))
				{
					array[j].children.add(array[i]);
					array[i].incoming++;
				}
			}
		}

		HashSet<Node> set = new HashSet<Node>();
		for (Node n : array)
			set.add(n);
		int result = 0;
		for (Node n : set)
		{
			if (n.incoming == 0)
			{
				System.out.print(n.s + " children: ");
				for(Node c : n.children)
					System.out.print(c.s + "  ");
				System.out.println();
				
				result = Math.max(result, dfs(n, set));
				
				
				System.out.println("----------------");
			}
				
		}

		return result;
	}

	/**
	 * @param n
	 * @param set
	 * @return
	 */
	private int dfs(Node n, HashSet<Node> set)
	{
		System.out.println(n.s);
		
		if (n.children.size() == 0)
		{
			System.out.println("+++++++++++++");
			n.length = 1;
			return 1;
		}

		int result = 0;
		for (Node child : n.children)
		{
			int length = (child.length > 0) ? child.length + 1
					: dfs(child, set) + 1;
			result = Math.max(result, length);
		}
		n.length = result;

		return result;
	}

	/**
	 * @param node
	 * @param node2
	 * @return
	 */
	private boolean isPre(Node n1, Node n2)
	{
		String s1 = n1.s;
		String s2 = n2.s;
		if (s1.length() != s2.length() - 1)
			return false;

		boolean skiped = false;
		int i1 = 0;
		int i2 = 0;
		while (i1 < s1.length())
		{
			if (s1.charAt(i1) != s2.charAt(i2))
			{
				if (!skiped)
				{
					i2++;
					skiped = true;
				}
				else
					return false;
			}
			else
			{
				i1++;
				i2++;
			}
			
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] words = new String[] { "qyssedya", "pabouk", "mjwdrbqwp",
				"vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw",
				"nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo",
				"qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa",
				"pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu",
				"nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr" };
		
		Q3 t = new Q3();
		t.longestStrChain(words);

	}

}
