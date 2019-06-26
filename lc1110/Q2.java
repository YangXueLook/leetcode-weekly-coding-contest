package lc1110;

public class Q2
{

	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	public int rangeSumBST(TreeNode root, int L, int R)
	{
		if (root == null)
			return 0;

		if (root.val >= L && root.val <= R)
			return rangeSumBST(root.left, L, root.val)
					+ rangeSumBST(root.right, root.val, R) + root.val;
		else if (root.val < L)
			return rangeSumBST(root.right, L, R);
		else
			return rangeSumBST(root.left, L, R);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
