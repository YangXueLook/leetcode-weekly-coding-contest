/**
 * lookiYang Xue
 * TODO
 * May 22, 2019
 * 2019
 */
package lc0518;

import java.util.Stack;

/**
 * @author looki
 * 
 */
public class Q2
{
	public String removeDuplicates(String S)
	{
		Stack<Character> stack = new Stack<Character>();
		for (char c : S.toCharArray())
		{
			if (!stack.isEmpty() && stack.peek() == c)
				stack.pop();
			else
				stack.push(c);
		}

		StringBuffer sb = new StringBuffer();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
