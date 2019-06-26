/**
 * lookiYang Xue
 * TODO
 * Jun 22, 2019
 * 2019
 */
package lc0622;

import java.math.BigDecimal;

/**
 * @author looki
 * 
 */
public class Q1
{
	public static double[] sampleStats(int[] a)
	{
		double[] result = new double[5];
		long sum = 0;
		int count = 0;

		int maxFre = 0;
		int maxFreIndex = -1;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;

		for (int i = 0; i < a.length; i++)
		{
			sum += (long) (i) * (long) (a[i]);
			count += a[i];
			if (a[i] > maxFre)
			{
				maxFre = a[i];
				maxFreIndex = i;
			}
			if (a[i] > 0)
			{
				min = Math.min(i, min);
				max = Math.max(i, max);
			}

		}
		System.out.println(sum + "  " + count + "  " + (double) (sum)
				/ (double) count);

	
		
		double mean = (double) (sum) / (double) count;
		double mode = (double) maxFreIndex;
		double median = 0.0;
		if (count % 2 == 1)
		{
			int half = count / 2;
			int currentCount = 0;
			for (int i = 0; i < a.length; i++)
			{
				if (currentCount <= half && currentCount + a[i] > half)
				{
					median = (double) i;
					break;
				}
				else
				{
					currentCount += a[i];
				}
			}
		}
		else
		{
			int half = count / 2 - 1;
			int currentCount = 0;
			for (int i = 0; i < a.length; i++)
			{
				if (currentCount <= half && currentCount + a[i] > half)
				{
					if (currentCount + a[i] > half + 1)
					{
						median = (double) i;
						break;
					}
					else
					{
						int first = i;
						i++;
						while (a[i] == 0)
							i++;
						int second = i;

						median = (double) (first + second) / 2;
						break;
					}

				}
				else
				{
					currentCount += a[i];
				}
			}
		}
		result[0] = (double) min;
		result[1] = (double) max;
		result[2] = mean;
		result[3] = median;
		result[4] = (double) maxFreIndex;

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// System.out.println(Double.MAX_VALUE);

		double[] result = sampleStats(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 289, 830,
				1296, 1935, 2528, 3044, 3593, 4042, 4689, 5193, 5851, 6465,
				6944, 7525, 8141, 8652, 9195, 9679, 10215, 10929, 11437, 11792,
				12515, 13000, 13741, 14201, 14461, 15415, 15969, 16529, 16817,
				17418, 18150, 18533, 19212, 19486, 20161, 20791, 21050, 21698,
				22152, 21483, 21042, 20570, 19946, 19708, 19506, 18863, 18249,
				18038, 17545, 17221, 16692, 16285, 15820, 15188, 14955, 14437,
				13833, 13844, 13246, 12745, 12529, 11931, 11434, 10976, 10461,
				9933, 9564, 9103, 8600, 8392, 7992, 7480, 6925, 6474, 5974,
				5539, 5153, 4663, 4214, 3724, 3282, 2903, 2350, 2002, 1617,
				1149, 650, 207, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		System.out.println(result[2]);
	}

}
