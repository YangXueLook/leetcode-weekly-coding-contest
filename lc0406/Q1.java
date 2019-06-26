package lc0406;

import java.util.HashSet;
import java.util.Stack;

public class Q1
{

	public String removeOuterParentheses(String S)
	{
		// (()()) (()) (()(()))
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		int left = -1;
		int right = -1;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < S.length(); i++)
		{
			char c = S.charAt(i);

			if (c == '(')
				stack.push(i);
			else
			{
				StringBuffer temp = new StringBuffer();
				if (stack.size() == 1)
				{
					left = stack.pop();
					right = i;
					set.add(left);
					set.add(right);
				}

				else
				{
					stack.pop();
				}

			}
		}
		for (int i = 0; i < S.length(); i++)
		{
			if (!set.contains(i))
				sb.append(S.charAt(i));
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
