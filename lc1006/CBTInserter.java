package lc1006;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class CBTInserter
{

	List<TreeNode> tree;

	public CBTInserter(TreeNode root)
	{
		tree = new ArrayList<>();
		tree.add(root);
		for (int i = 0; i < tree.size(); ++i)
		{
			if (tree.get(i).left != null)
				tree.add(tree.get(i).left);
			if (tree.get(i).right != null)
				tree.add(tree.get(i).right);
		}
	}

	public int insert(int v)
	{
		int N = tree.size();
		TreeNode node = new TreeNode(v);
		tree.add(node);
		if (N % 2 == 1)
			tree.get((N - 1) / 2).left = node;
		else
			tree.get((N - 1) / 2).right = node;
		return tree.get((N - 1) / 2).val;
	}

	public TreeNode get_root()
	{
		return tree.get(0);
	}

	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	//
	// private TreeNode root;
	// private Queue<TreeNode> q = new LinkedList<TreeNode>();
	// private Queue<TreeNode> currentActiveLevel = new LinkedList<TreeNode>();
	// private Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
	//
	// public CBTInserter(TreeNode root)
	// {
	// this.root = root;
	// q.add(root);
	// int currentLevel = 0;
	// int activeLevel = -1;
	// while(!q.isEmpty())
	// {
	// int n = q.size();
	// currentLevel++;
	//
	// for(int i = 0; i < n; i++)
	// {
	// TreeNode head = q.poll();
	// if(head.left != null)
	// q.add(head.left);
	// if(head.right != null)
	// q.add(head.right);
	//
	// if(head.right == null)
	// {
	// if(!currentActiveLevel.isEmpty() && activeLevel != currentLevel)
	// {
	// nextLevel.add(head);
	// }
	// else
	// {
	// currentActiveLevel.add(head);
	// activeLevel = currentLevel;
	// }
	// }
	// }
	//
	// }
	// System.out.println(currentActiveLevel.size());
	// System.out.println(nextLevel.size());
	//
	// }
	//
	// public int insert(int v)
	// {
	// TreeNode acitve = currentActiveLevel.peek();
	// if(acitve.left == null)
	// {
	// acitve.left = new TreeNode(v);
	// return acitve.val;
	// }
	// else
	// {
	// acitve.right = new TreeNode(v);
	// currentActiveLevel.poll();
	// nextLevel.add(acitve.left);
	// nextLevel.add(acitve.right);
	// if(currentActiveLevel.isEmpty())
	// {
	// currentActiveLevel = nextLevel;
	// nextLevel = new LinkedList<TreeNode>();
	// }
	//
	// return acitve.val;
	// }
	// }
	//
	// public TreeNode get_root()
	// {
	// return root;
	// }

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		CBTInserter t = new CBTInserter(root);

	}

}
