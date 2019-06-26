/**
 * lookiYang Xue
 * TODO
 * Jun 8, 2019
 * 2019
 */
package lc0608;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author looki
 * 
 */
public class Q2
{

	public int numTilePossibilities(String tiles)
	{
		int[] array = new int[tiles.toCharArray().length];
		for (int i = 0; i < array.length; i++)
			array[i] = tiles.charAt(i) - '0';

		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(array);
		backtrack(list, new ArrayList<Integer>(), array, 0);

		int sum = 0;

		for (List<Integer> l : list)
		{
			sum += count(l);
		}

		return sum;
	}

	/**
	 * @param l
	 * @return
	 */
	private int count(List<Integer> l)
	{
		if (l.size() == 0)
			return 0;

		int result = factorial(l.size());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : l)
		{
			if (!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}

		for (Integer i : map.values())
		{
			result = result / factorial(i);
		}

		return result;
	}

	/**
	 * @param size
	 * @return
	 */
	private int factorial(int n)
	{
		int result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;

		return result;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] nums, int start)
	{
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++)
		{
			if (i > start && nums[i] == nums[i - 1])
				continue;
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
