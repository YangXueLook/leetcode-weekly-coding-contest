/**
 * lookiYang Xue
 * TODO
 * Jun 1, 2019
 * 2019
 */
package lc0601;

import java.util.HashMap;

/**
 * @author looki
 * 
 */
public class Q2
{

	public int maxEqualRowsAfterFlips(int[][] matrix)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int[] row : matrix)
		{
			StringBuffer sb1 = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			for (int i : row)
			{
				sb1.append(i);
				sb2.append(i ^ 1);
			}

			if (map.containsKey(sb1.toString()))
				map.put(sb1.toString(), map.get(sb1.toString()) + 1);
			else if (map.containsKey(sb2.toString()))
				map.put(sb2.toString(), map.get(sb2.toString()) + 1);
			else
				map.put(sb1.toString(), 1);
		}

		int max = 0;
		for (Integer i : map.values())
			max = Math.max(max, i);

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
