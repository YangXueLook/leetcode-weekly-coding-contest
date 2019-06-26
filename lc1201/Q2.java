package lc1201;

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

	public boolean flipEquiv(TreeNode root1, TreeNode root2)
	{
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;
		else if (root1.val != root2.val)
			return false;
		else
			return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right,
					root2.right))
					|| (flipEquiv(root1.left, root2.right) && flipEquiv(
							root1.right, root2.left));

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
