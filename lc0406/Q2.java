package lc0406;

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

	public static int sumRootToLeaf(TreeNode root)
	{
		int mod = 1000000000 + 7;
		int result = helper(root, 0, mod);

		return result;
	}

	private static int helper(TreeNode root, int current, int mod)
	{
		if (root.left == null && root.right == null)
		{

			return (current * 2 + root.val) % mod;
		}
		else
		{
			int l = 0;
			int r = 0;
			if (root.left != null)
				l = helper(root.left, (current * 2 + root.val) % mod, mod);
			if (root.right != null)
				r = helper(root.right, (current * 2 + root.val) % mod, mod);

			return (l + r) % mod;
		}

	}

	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(0);
		TreeNode n7 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		sumRootToLeaf(n1);

	}

}
