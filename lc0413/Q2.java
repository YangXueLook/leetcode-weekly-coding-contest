package lc0413;

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

	static class TreeNodePlus
	{
		int val;
		int min;
		int max;
		TreeNode left;
		TreeNode right;

		TreeNodePlus(int x, int min, int max)
		{
			val = x;
			this.min = min;
			this.max = max;
		}
	}

	public static int result = 0;

	public static int maxAncestorDiff(TreeNode root)
	{
		helper(root);

		return result;
	}

	// public static int maxAncestorDiff(TreeNode root)
	// {
	// return traverse(root, root.val, root.val);
	//
	// }

	private static int traverse(TreeNode root, int min, int max)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	private static int[] helper(TreeNode root)
	{
		if (root.left == null && root.right == null)
			return new int[] { root.val, root.val };
		else if (root.left == null)
		{
			int[] rightMinMax = helper(root.right);
			int max = Math.max(root.val, rightMinMax[1]);
			int min = Math.min(root.val, rightMinMax[0]);
			result = Math.max(result, Math.max(Math.abs(root.val - max),
					Math.abs(root.val - min)));

			// System.out.println(root.val + "  " + min + "  " + max + "  "
			// + result);

			return new int[] { min, max };
		}

		else if (root.right == null)
		{
			int[] leftMinMax = helper(root.left);

			int max = Math.max(root.val, leftMinMax[1]);
			int min = Math.min(root.val, leftMinMax[0]);
			result = Math.max(result, Math.max(Math.abs(root.val - max),
					Math.abs(root.val - min)));

			// System.out.println(root.val + "  " + min + "  " + max + "  "
			// + result);
			return new int[] { min, max };
		}
		else
		{
			int[] leftMinMax = helper(root.left);
			int[] rightMinMax = helper(root.right);

			int max = Math.max(root.val,
					Math.max(leftMinMax[1], rightMinMax[1]));
			int min = Math.min(root.val,
					Math.min(leftMinMax[0], rightMinMax[0]));
			result = Math.max(result, Math.max(Math.abs(root.val - max),
					Math.abs(root.val - min)));

			// System.out.println(root.val + "  " + min + "  " + max + "  "
			// + result);
			return new int[] { min, max };
		}

	}

	public static void main(String[] args)
	{
		// TreeNode n1 = new TreeNode(8);
		// TreeNode n2 = new TreeNode(3);
		// TreeNode n3 = new TreeNode(10);
		// TreeNode n4 = new TreeNode(1);
		// TreeNode n5 = new TreeNode(6);
		// TreeNode n6 = new TreeNode(14);
		// TreeNode n7 = new TreeNode(4);
		// TreeNode n8 = new TreeNode(7);
		// TreeNode n9 = new TreeNode(13);

		// n1.left = n2;
		// n1.right = n3;
		//
		// n2.left = n4;
		// n2.right = n5;
		//
		// n3.right = n6;
		//
		// n5.left = n7;
		// n5.right = n8;
		//
		// n6.left = n9;

		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		// TreeNode n3 = new TreeNode(0);
		// TreeNode n4 = new TreeNode(3);

		n1.right = n2;
		// n2.right = n3;
		// n3.left = n4;

		maxAncestorDiff(n1);
		System.out.println(result);

	}

}
