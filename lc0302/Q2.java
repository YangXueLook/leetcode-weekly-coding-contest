package lc0302;

import java.util.Stack;

public class Q2
{

	public static boolean isValid(String S)
	{
		if (S.length() <= 2)
			return false;

		Stack<Character> stack = new Stack<Character>();

		for (char c : S.toCharArray())
		{
			if (c == 'c' && stack.size() >= 2)
			{
				char b = stack.pop();
				char a = stack.pop();
				if (!(a == 'a' && b == 'b'))
				{
					stack.push(a);
					stack.push(b);
					stack.push(c);
				}
			}
			else
				stack.push(c);
		}

		return stack.size() == 0;
	}

	public static void main(String[] args)
	{
		System.out.println(isValid("abccba"));

	}

}
