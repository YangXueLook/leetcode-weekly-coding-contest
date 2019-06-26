package lc0504;

import java.util.HashMap;
import java.util.HashSet;

public class Q2
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

	public TreeNode bstToGst(TreeNode root)
	{

		helper(root, 0);
		return root;
	}

	private int helper(TreeNode root, int parentSum)
	{
		if (root == null)
			return 0;

		int orgVal = root.val;
		int rightSum = getSum(root.right);
		helper(root.right, parentSum);
		root.val = root.val + rightSum + parentSum;
		int leftSum = getSum(root.left);
		helper(root.left, root.val);

		return orgVal + rightSum + leftSum;
	}

	private int getSum(TreeNode root)
	{
		if (root == null)
			return 0;
		else
			return root.val + getSum(root.left) + getSum(root.right);
	}

	public int[] gardenNoAdj(int N, int[][] paths)
	{
		int[] result = new int[N];
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int[] p : paths)
		{
			if (!map.containsKey(p[0]))
				map.put(p[0], new HashSet<Integer>());
			if (!map.containsKey(p[1]))
				map.put(p[1], new HashSet<Integer>());
			map.get(p[0]).add(p[1]);
			map.get(p[1]).add(p[0]);

		}
		int[][] availableColors = new int[N + 1][4];
		for (int i = 1; i <= N; i++)
		{
			availableColors[i][0] = 1;
			availableColors[i][1] = 2;
			availableColors[i][2] = 3;
			availableColors[i][3] = 4;
		}
		for (int i = 1; i <= N; i++)
		{
			int color = -1;
			for (int j = 0; j < 4; j++)
			{
				if (availableColors[i][j] != -1)
				{
					color = availableColors[i][j];
					break;
				}
			}
			result[i - 1] = color;
			
			if(map.containsKey(i))
			{
				for (int adj : map.get(i))
				{
					availableColors[adj][color - 1] = -1;
				}
			}
			
			

		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
