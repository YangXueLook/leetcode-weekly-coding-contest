/**
 * lookiYang Xue
 * TODO
 * Jun 15, 2019
 * 2019
 */
package lc0615;

/**
 * @author looki
 * 
 */
public class Q1
{

	public static void duplicateZeros(int[] arr)
	{
		int zeroCount = 0;
		for (int i : arr)
		{
			if (i == 0)
				zeroCount++;
		}
		
		boolean isNeedExtroZero = false;
		
		int index = arr.length - 1;
		while (zeroCount > 0)
		{
			if (arr[index] == 0)
			{
				if(zeroCount > 1)
				{
					zeroCount -= 2;
					index--;
				}
				else
				{
					isNeedExtroZero = true;
					zeroCount--;
					index--;
				}
				
			}
			else
			{
				zeroCount--;
				index--;
			}
		}
		System.out.println(index);
		
		int backIndex = arr.length - 1;
		if(isNeedExtroZero)
		{
			arr[backIndex] = 0;
			backIndex--;
		}
		while (backIndex >= 0 && index >= 0)
		{
			if (arr[index] == 0)
			{
				arr[backIndex] = 0;
				backIndex--;
				arr[backIndex] = 0;
				backIndex--;
				index--;
			}
			else
			{
				arr[backIndex] = arr[index];
				backIndex--;
				index--;
			}
		}
		
		for(int i : arr)
            System.out.print(i + " ");
         System.out.println();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		duplicateZeros(new int[]{8,4,5,0,0,0,0,7});

	}

}
