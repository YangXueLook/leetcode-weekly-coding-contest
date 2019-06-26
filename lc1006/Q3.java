package lc1006;

public class Q3
{

	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args)
	{
		int[] a = { -3, -1, 0, -6, -2 };
		int n = a.length;
		int[] b = new int[n];
		int sum = 0;
		// 第一种情况，正常，最大max数组的取值在首尾之间
		boolean allfushu = true;
		for (int i = 0; i < n; i++)
		{
			if (a[i] >= 0)
				allfushu = false;
		}
		int sum1 = find(a, n);
		// 第二种情况，部分头+部分尾；中间部分没选择，因为他们的sum最小且为负
		// 所以才启发了思路去找没被选中的中间部分：将数组取反 重新找max
		for (int i = 0; i < n; i++)
		{
			b[i] = -a[i];
			sum += a[i];
			// sum是数组总和
		}
		if (!allfushu)
		{
			int temp = find(b, n);
			int sum2 = sum + temp;
			// 这里少考虑一种情况：数值全为负的时候，循环数组的最大子数组的和 
			// 第一种算出来是-1，而第二种算出来为0，如果不允许是空串的话应该最后结果为-1的
			// 所以这里最好加一个判断，如果全为负直接用第一种就行，不要第二种判断了，否则会导致出错。
			max = Math.max(sum1, sum2);
			System.out.print(max);
		}
		else
		{
			System.out.print(sum1);
		}
	}

	public int maxSubarraySumCircular(int[] A)
	{
		int max = Integer.MIN_VALUE;
		int n = A.length;
		int[] B = new int[n];
		int sum = 0;
		
		boolean allNegative = true;
		for (int i = 0; i < n; i++)
		{
			if (A[i] >= 0)
				allNegative = false;
		}
		int sum1 = find(A, n);
		
		for (int i = 0; i < n; i++)
		{
			B[i] = -A[i];
			sum += A[i];
			
		}
		if (!allNegative)
		{
			int temp = find(B, n);
			int sum2 = sum + temp;
			
			max = Math.max(sum1, sum2);
			return max;
		}
		else
		{
			return sum1;
		}
	}
	
	private static int find(int[] a, int n)
	{
		if (a == null)
			return 0;
		int sum = a[0];
		int max1 = max;
		for (int i = 1; i < n; i++)
		{
			if (sum <= 0)
				sum = a[i];
			else
				sum += a[i];
			max1 = max1 < sum ? sum : max1;
		}
		return max1;
	}

}
