package lc1006;

import java.util.ArrayList;

public class Q1
{
	public String reverseOnlyLetters(String S)
	{
		ArrayList<Integer> nonLetterIndex = new ArrayList<Integer>();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < S.length(); i++)
		{
			if (isLetter(S.charAt(i)))
			{
				result.append(S.charAt(i));
			}
			else
			{
				nonLetterIndex.add(i);
			}
		}
		result.reverse();
		for (Integer i : nonLetterIndex)
		{
			result.insert(i.intValue(), S.charAt(i));
		}

		return result.toString();
	}

	private boolean isLetter(char c)
	{
		
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
