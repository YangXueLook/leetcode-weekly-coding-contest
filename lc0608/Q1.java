/**
 * lookiYang Xue
 * TODO
 * Jun 8, 2019
 * 2019
 */
package lc0608;

import java.util.ArrayList;

/**
 * @author looki
 * 
 */
public class Q1
{

	public String[] findOcurrences(String text, String first, String second)
	{
		ArrayList<String> list = new ArrayList<String>();
		String[] array = text.split(" ");
		for (int i = 0; i < array.length - 2; i++)
		{
			if (array[i].equals(first)
					&& array[i + 1].equals(second)
					&& !(array[i + 2].equals(first) || array[i + 2]
							.equals(second)))
				list.add(array[i + 2]);
		}

		String[] result = new String[list.size()];

		for (int i = 0; i < result.length; i++)
			result[i] = list.get(i);
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
