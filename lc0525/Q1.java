/**
 * lookiYang Xue
 * TODO
 * May 25, 2019
 * 2019
 */
package lc0525;

import java.util.Arrays;

/**
 * @author looki
 * 
 */
public class Q1
{
	public int heightChecker(int[] heights)
	{
		int count = 0;
		int[] array = new int[heights.length];
		for (int i = 0; i < heights.length; i++)
		{
			array[i] = heights[i];
		}
		Arrays.sort(array);
		for (int i = 0; i < heights.length; i++)
		{
			if (array[i] != heights[i])
				count++;
		}

		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.print("sadf");

	}

}
