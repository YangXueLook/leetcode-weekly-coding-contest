package lc0430;

import java.util.HashMap;
import java.util.HashSet;

public class StreamChecker
{
	static class Trie
	{
		char val;
		boolean isEnd = false;
		HashMap<Character, Trie> next = new HashMap<Character, Trie>();

		Trie(char c)
		{
			this.val = c;
		}
	}

	StringBuffer sb;
	Trie root = new Trie(' ');

	public StreamChecker(String[] words)
	{
		for (String s : words)
		{
			add(root, s);
		}

		sb = new StringBuffer();

	}

	private void add(Trie root, String s)
	{
		for (int i = s.length() - 1; i >= 0; i--)
		{
			char c = s.charAt(i);
			if (root.next.containsKey(c))
			{
				root = root.next.get(c);
				if (i == 0)
					root.isEnd = true;
			}
			else
			{
				Trie nextNode = new Trie(c);
				root.next.put(c, nextNode);
				root = root.next.get(c);
				if (i == 0)
					root.isEnd = true;
			}
		}

	}

	public boolean query(char letter)
	{
		sb.append(letter);

		return search(root, sb);
	}

	private boolean search(Trie root, StringBuffer sb)
	{
		for (int i = sb.length() - 1; i >= 0; i--)
		{
			char c = sb.charAt(i);
			if (!root.next.containsKey(c))
				return false;
			else
			{
				if (root.next.get(c).isEnd)
					return true;
				else
					root = root.next.get(c);
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
