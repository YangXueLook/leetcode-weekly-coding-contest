package lc0330;

import java.util.ArrayList;
import java.util.Stack;

import round1C.A;

public class Q3
{
	static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}

	}

	private int[] helper(int a[])
	{
		int len = a.length;
		int next = 0;
		int[] result = new int[len];

		for (int i = 0; i < len; i++)
		{
			next = 0;
			for (int j = i + 1; j < len; j++)
			{
				if (a[i] < a[j])
				{
					next = a[j];
					break;
				}
			}

			result[i] = next;
		}
		return result;
	}

	public int[] nextLargerNodes(ListNode head)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (head != null)
		{
			list.add(head.val);
			head = head.next;
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			array[i] = list.get(i);

		int[] result = new int[array.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < array.length; i++)
		{
			while (!stack.isEmpty() && array[stack.peek()] < array[i])
				result[stack.pop()] = array[i];
			stack.push(i);
		}
		return result;

	}

	private void helper(int[] array, int[] result, int start, int end,
			int maxIndex)
	{
		System.out.println(start + " " + end + " " + maxIndex);

		if (start == end)
		{
			result[start] = 0;
			return;
		}
		else if (start > end)
			return;
		else
		{

			result[maxIndex] = 0;
			int current = array[start];
			int currentIndex = start;
			for (int i = start; i <= maxIndex; i++)
			{
				System.out.println(current + "----" + i + "    " + array[i]);
				if (current >= array[i])
				{

				}
				else
				{
					for (int j = currentIndex; j < i; j++)
					{
						result[j] = array[i];
						// System.out.println(result[j]);
					}
					current = array[i];
					currentIndex = i;

				}
			}

			int nextMax = -1;
			int nextMaxIndex = -1;
			for (int i = maxIndex + 1; i <= end; i++)
			{
				if (array[i] > nextMax)
				{
					nextMax = array[i];
					nextMaxIndex = i;
				}
			}

			helper(array, result, maxIndex + 1, end, nextMaxIndex);
		}

	}

	public static void main(String[] args)
	{
		Q3 t = new Q3();
		ListNode head = new ListNode(9);
		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(6);
		ListNode n5 = new ListNode(9);
		// ListNode n2 = new ListNode(5);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		int[] array = t.nextLargerNodes(head);
		// for (int i : array)
		// System.out.print(i + "\t");

	}

}
