package lc0309;

public class Q4
{

	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	public TreeNode bstFromPreorder(int[] preorder)
	{
		TreeNode result = helper(preorder, 0, preorder.length - 1);

		return result;
	}

	private TreeNode helper(int[] preorder, int low, int high)
	{
		System.out.println(low + "      " + high);
		
		if (low == high)
			return new TreeNode(preorder[low]);
		if (low > high)
			return null;

		TreeNode root = new TreeNode(preorder[low]);
		int val = root.val;
		int leftChildLen = 0;
		for (int i = low + 1; i <= high; i++)
		{
			if (preorder[i] < val)
				leftChildLen++;
			else
				break;
		}

		root.left = helper(preorder, low + 1, low + leftChildLen);
		root.right = helper(preorder, low + leftChildLen + 1, high);

		return root;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Q4 t = new Q4();
		TreeNode root = t.bstFromPreorder(new int[]{8,5,1,7,10,12});
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
		System.out.println(root.right.right.val);
		
	}

}
