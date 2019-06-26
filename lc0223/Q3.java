package lc0223;

public class Q3
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

	public TreeNode insertIntoMaxTree(TreeNode root, int val)
	{
		if(root == null)
			return new TreeNode(val);
		
		else if(val > root.val)
		{
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		else if(root.right == null)
		{
			TreeNode newRoot = new TreeNode(val);
			root.right = newRoot;
			return root;
		}
		else if(val > root.right.val)
		{
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root.right;
			root.right = newRoot;
			return root;
		}
		else
		{
			root.right = insertIntoMaxTree(root.right, val);
			return root;
		}
	
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
