package lc0413;

import java.util.Stack;

public class Q4
{

	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	public static TreeNode recoverFromPreorder(String S)
	{
		Stack<TreeNode> statck = new Stack<TreeNode>();
		
		TreeNode result = new  TreeNode(-1);
		
		int currentDepth = 0;
		int previousDepth = -1;
		int i = 0;
		while( i < S.length())
		{
			char c = S.charAt(i);
			if(c == '-')
			{
				currentDepth++;
				i++;
			}
				
			else
			{
				int val = c - '0';
				while(i < S.length() - 1 && S.charAt(i + 1) != '-')
				{
					val = val * 10 + (S.charAt(i + 1) - '0');
					i++;
				}
				
				System.out.println(val);
				
				TreeNode node = new TreeNode(val);
				if(currentDepth == 0)
					result = node;
				
				
				i++;
			}
		}
		
		return result;
	}

	public static void main(String[] args)
	{
		recoverFromPreorder("1-401--349---90--88");

	}

}
