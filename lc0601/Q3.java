/**
 * lookiYang Xue
 * TODO
 * Jun 1, 2019
 * 2019
 */
package lc0601;

import java.util.ArrayList;

/**
 * @author looki
 * 
 */
public class Q3
{
	public int[] addNegabinary(int[] a1, int[] a2)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		// a1 longer
		if (a1.length < a2.length)
		{
			int[] temp = a1;
			a1 = a2;
			a2 = temp;
		}

		int l = 0;
		int r = a1.length - 1;
		while (l < r)
		{
			int temp = a1[l];
			a1[l] = a1[r];
			a1[r] = temp;
			l++;
			r--;
		}

		l = 0;
		r = a2.length - 1;
		while (l < r)
		{
			int temp = a2[l];
			a2[l] = a2[r];
			a2[r] = temp;
			l++;
			r--;
		}

		int carry = 0;
		for (int i = 0; i < a2.length; i++)
		{
			if (carry == 0)
			{
				if (a1[i] == 0 && a2[i] == 0)
					list.add(0);
				else if (a1[i] == 1 && a2[i] == 1)
				{
					list.add(0);
					carry = -1;
				}
				else
					list.add(1);
			}
			else if (carry == -1)
			{
				if (a1[i] == 0 && a2[i] == 0)
				{
					list.add(1);
					carry = 1;
				}

				else if (a1[i] == 1 && a2[i] == 1)
				{
					list.add(1);
					carry = 0;
				}
				else
				{
					list.add(0);
					carry = 0;
				}
			}
			else
			{
				if (a1[i] == 0 && a2[i] == 0)
				{
					list.add(1);
					carry = 0;
				}

				else if (a1[i] == 1 && a2[i] == 1)
				{
					list.add(1);
					carry = -1;
				}
				else
				{
					list.add(0);
					carry = -1;
				}
			}
		}

		for (int i = a2.length; i < a1.length; i++)
		{
			if (carry == 0)
			{
				list.add(a1[i]);
			}
			else if (carry == -1)
			{
				if (a1[i] == 1)
				{
					list.add(0);
					carry = 0;
				}
				else
				{
					list.add(1);
					carry = 1;
				}
			}
			else
			// carry == 1
			{
				if (a1[i] == 1)
				{
					list.add(0);
					carry = -1;
				}
				else
				{
					list.add(1);
					carry = 0;
				}
			}
		}

		if (carry == -1)
		{
			list.add(1);
			list.add(1);
		}
		else if (carry == 1)
			list.add(1);

		int index = list.size() - 1;
		while (index >= 1 && list.get(index) == 0)
		{
			list.remove(index);
			index--;
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = list.get(list.size() - i - 1);

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Q3 t = new Q3();
		t.addNegabinary(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 1 });

	}

}
