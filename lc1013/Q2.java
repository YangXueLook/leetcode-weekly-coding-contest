package lc1013;

import java.util.Stack;

public class Q2
{

	public int minAddToMakeValid(String S)
	{
		char[] array = S.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int result = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == ')' && stack.size() == 0)
			{
				result++;
			}
			else if (array[i] == ')')
			{
				stack.pop();
			}
			else
			{
				stack.push(array[i]);
			}
		}

		return result + stack.size();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
