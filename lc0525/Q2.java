/**
 * lookiYang Xue
 * TODO
 * May 25, 2019
 * 2019
 */
package lc0525;

/**
 * @author looki
 * 
 */
public class Q2
{
	public int maxSatisfied(int[] customers, int[] grumpy, int X)
	{
		
		int sum = 0;
		for (int i = 0; i < customers.length; i++)
		{
			if (grumpy[i] == 0)
			{
				sum += customers[i];
			}

		}

		int maxExtra = 0;
		int extra = 0;

		for (int i = 0; i < X; i++)
		{
			if (grumpy[i] == 1)
			{
				extra += customers[i];
			}
		}

		maxExtra = Math.max(maxExtra, extra);

		for (int i = 1; i + X - 1 < customers.length; i++)
		{
			if (grumpy[i - 1] == 1)
				extra -= customers[i - 1];
			if (grumpy[i + X - 1] == 1)
				extra += customers[i + X - 1];

			maxExtra = Math.max(maxExtra, extra);
		}

		return sum + maxExtra;
	}

	/**
	 * @param args
	 */

	// [2,6,6,9]
	// [0,0,1,1]
	// 1
	public static void main(String[] args)
	{
		Q2 t = new Q2();
		t.maxSatisfied(new int[] { 2, 6, 6, 9 }, new int[] { 0, 0, 1, 1 }, 1);

	}

}
