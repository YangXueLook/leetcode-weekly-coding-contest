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
public class Q3
{
	public int[] prevPermOpt1(int[] A)
	{

		int backIndex = A.length - 1;
		int firstValue = -1;
		int firstIndex = -1;
		// find first reversed pair. scan from end to start
		while (backIndex > 0)
		{
			if (A[backIndex - 1] > A[backIndex])
			{
				firstValue = A[backIndex - 1];
				firstIndex = backIndex - 1;
				break;
			}
			backIndex--;
		}
		if (backIndex == 0)
			return A;
		int secondValue = -1;
		int secondIndex = -1;
		// find next value smaller than first
		for (int i = firstIndex + 1; i < A.length; i++)
		{
			if (A[i] < firstValue)
				secondValue = Math.max(secondValue, A[i]);
		}
		// find position of next value
		for (int i = firstIndex + 1; i < A.length; i++)
		{
			if (secondValue == A[i])
			{
				secondIndex = i;
				break;
			}
		}

		int temp = A[firstIndex];
		A[firstIndex] = A[secondIndex];
		A[secondIndex] = temp;

		return A;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
