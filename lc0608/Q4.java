/**
 * lookiYang Xue
 * TODO
 * Jun 8, 2019
 * 2019
 */
package lc0608;

import java.util.Stack;

/**
 * @author looki
 * 
 */
public class Q4
{

	public String smallestSubsequence(String text)
	{
		Stack<Character> stack = new Stack<Character>();

		int count[] = new int[26];
		boolean used[] = new boolean[26];
		for (char c : text.toCharArray())
		{
			count[c - 'a']++;
		}
		for (char c : text.toCharArray())
		{
			count[c - 'a']--;
			if (!used[c - 'a'])// must keep it, since it has not been used
								// before
			{
				while (!stack.isEmpty() && stack.peek() > c
						&& count[stack.peek() - 'a'] > 0)
				{
					// remove all larger chars before c, these chars can be
					// found later
					used[stack.peek() - 'a'] = false;
					stack.pop();
				}
				used[c - 'a'] = true;
				stack.push(c);
			}
		}

		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}

	/**
	 * @param array
	 * @param index
	 * @return
	 */
	private char findNextChar(char[] array, int start)
	{
		char result = array[start];
		for (int i = start + 1; i < array.length; i++)
		{
			if (array[i] != '-')
				return array[i];
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
