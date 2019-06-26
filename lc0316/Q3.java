package lc0316;

public class Q3
{

	public int shipWithinDays(int[] weights, int D)
	{
		int left = 0, right = 0;
		for (int w : weights)
		{
			left = Math.max(left, w);
			right += w;
		}
		while (left < right)
		{
			int mid = (left + right) / 2, need = 1, cur = 0;
			for (int w : weights)
			{
				if (cur + w > mid)
				{
					need += 1;
					cur = 0;
				}
				cur += w;
			}
			if (need > D)
				left = mid + 1;
			else
				right = mid;
		}
		return left;

		// int len = weights.length;
		//
		// int[][] M = new int[len + 1][D + 1];
		// int[] cum = new int[len + 1];
		// for (int i = 1; i <= weights.length; i++)
		// cum[i] = cum[i - 1] + weights[i - 1];
		//
		// for (int i = 1; i <= weights.length; i++)
		// M[i][1] = cum[i];
		// for (int i = 1; i <= D; i++)
		// M[1][i] = weights[0];
		//
		// for (int i = 2; i <= D; i++)
		// {
		// for (int j = 2; j <= weights.length; j++)
		// {
		// int best = Integer.MAX_VALUE;
		// for (int p = 1; p <= j; p++)
		// {
		// best = Math.min(best,
		// Math.max(M[p][i - 1], cum[j] - cum[p]));
		// }
		// M[j][i] = best;
		// }
		// }
		// return M[weights.length][D];
	}

	// public static final int MAX_N = 100;

	// public static int findMax(int A[], int n, int k)
	// {
	// int[][] M = new int[MAX_N + 1][MAX_N + 1];
	// int[] cum = new int[MAX_N + 1];
	// for (int i = 1; i <= n; i++)
	// cum[i] = cum[i - 1] + A[i - 1];
	//
	// for (int i = 1; i <= n; i++)
	// M[i][1] = cum[i];
	// for (int i = 1; i <= k; i++)
	// M[1][i] = A[0];
	//
	// for (int i = 2; i <= k; i++)
	// {
	// for (int j = 2; j <= n; j++)
	// {
	// int best = Integer.MAX_VALUE;
	// for (int p = 1; p <= j; p++)
	// {
	// best = Math.min(best,
	// Math.max(M[p][i - 1], cum[j] - cum[p]));
	// }
	// M[j][i] = best;
	// }
	// }
	// return M[n][k];
	// }

	public static int sum(int arr[], int start, int end) // inclusive of end
	{
		int s = 0;
		for (int i = start; i <= end; i++)
			s += arr[i];
		return s;
	}

	public static int balance(int arr[], int size, int partitions)
	{
		int[] table = new int[size * partitions];// be sure to deallocate
		for (int i = 0; i < size; i++)
			table[i * partitions] = sum(arr, 0, i);
		for (int k = 1; k <= partitions; k++)
			table[k - 1] = arr[0];

		for (int i = 1; i < size; i++)
			for (int k = 2; k <= partitions; k++)
			{
				int min_ = 10000;
				for (int j = 0; j <= i - 1; j++)
				{
					min_ = Math.min(
							min_,
							Math.max(table[(j - 1) * partitions + k - 2],
									sum(arr, j + 1, i)));
				}
				table[i * partitions + k - 1] = min_;
			}

		return table[size * partitions - 1];
	}

	// int main()
	// {
	// int A[] = {1,2,3,4,5,6,7,8};
	// cout<<balance(A, sizeof(A)/sizeof(int), 7)<<endl;
	// getchar();
	// return 0;
	// }

	public static void main(String[] args)
	{
		int A[] = { 1, 2, 3, 1, 1 };
		// System.out.println(suanfa(A, 4));

	}

}
