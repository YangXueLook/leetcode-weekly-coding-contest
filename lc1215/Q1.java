package lc1215;

import java.util.LinkedList;
import java.util.Queue;

public class Q1
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

	public boolean isCompleteTree(TreeNode root)
	{
		if (root == null)
			return true;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		boolean nextLayerComplete = true;
		TreeNode t;
		while (!q.isEmpty())
		{
			if (nextLayerComplete)
			{
				int size = q.size();
				for (int i = 0; i < size; i++)
				{
					t = q.poll();
					if (nextLayerComplete)
					{
						if (t.left != null)
							q.add(t.left);
						else
							nextLayerComplete = false;
						if (nextLayerComplete)
						{
							if (t.right != null)
								q.add(t.right);
							else
								nextLayerComplete = false;
						}
						else if (t.right != null)
							return false;

					}
					else
					{
						if (t.left != null || t.right != null)
							return false;
					}
				}

			}
			else
			{
				int size = q.size();
				for (int i = 0; i < size; i++)
				{
					t = q.poll();
					if (t.left != null || t.right != null)
						return false;
				}
			}

		}

		return true;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
