/**
 * lookiYang Xue
 * TODO
 * Jun 8, 2019
 * 2019
 */
package lc0608;

/**
 * @author looki
 * 
 */
public class Q3
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

	class SumTreeNode
	{
		int val;
		int sum;
		SumTreeNode left;
		SumTreeNode right;

		SumTreeNode(int x)
		{
			val = x;
		}
	}

	public TreeNode sufficientSubset(TreeNode root, int limit)
	{
		SumTreeNode sumRoot = buildSumTree(root);

		sumRoot = trim(sumRoot, limit, 0);

		return buildOrgTree(sumRoot);
	}

	/**
	 * @param sumRoot
	 * @return
	 */
	private TreeNode buildOrgTree(SumTreeNode sumRoot)
	{
		if (sumRoot == null)
			return null;
		else
		{
			TreeNode root = new TreeNode(sumRoot.val);
			root.left = buildOrgTree(sumRoot.left);
			root.right = buildOrgTree(sumRoot.right);
			return root;
		}

	}

	/**
	 * @param sumRoot
	 * @param limit
	 * @param i
	 * @return
	 */
	private SumTreeNode trim(SumTreeNode sumRoot, int limit, int presum)
	{
		if (limit > presum + sumRoot.sum)
		{
			System.out.println(limit + "\t" + sumRoot.val+ "\t" + sumRoot.sum+ "\t" + presum);
			return null;
		}
			
		else
		{
			if (sumRoot.left != null)
				sumRoot.left = trim(sumRoot.left, limit, presum + sumRoot.val);
			if (sumRoot.right != null)
				sumRoot.right = trim(sumRoot.right, limit, presum + sumRoot.val);
			return sumRoot;
		}

	}

	/**
	 * @param root
	 * @return
	 */
	private SumTreeNode buildSumTree(TreeNode root)
	{
		if (root == null)
			return null;

		SumTreeNode result = new SumTreeNode(root.val);
		SumTreeNode left = buildSumTree(root.left);
		SumTreeNode right = buildSumTree(root.right);

		int lsum = root.val;
		int rsum = root.val;

		if (left != null)
			lsum += left.sum;
		if (right != null)
			rsum += right.sum;
		result.sum = Math.max(lsum, rsum);
		
		result.left = left;
        result.right = right;

//		System.out.println(result.val + "\t" + result.sum);
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
