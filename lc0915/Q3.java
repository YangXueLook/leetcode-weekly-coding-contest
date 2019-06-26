package lc0915;

//For each element A[i] with scope [m, n], 
//A[i] will generate (m-i+1)*(i-n+1) subarrays, 
//in which A[i] is the smallest, so res+=(hi-i+1)*(i-lo+1)*A[i]
//		
//e.g Say we have [3,1,2,4] and the smallest is [1], 
//we can divide the array into 2 parts: [3,1] and [1,2,4], 
//and the number of subarrays is 2*3=6.
//Why? Because in the left part we can choose [3,1] or [1], 
//in the right part we can choose[1,2,4], [1,2] or [1], 
//the rest is just combination.

import java.util.Stack;

public class Q3
{
	static final int M = (int) 1e9 + 7;

	public static int sumSubarrayMins(int[] A)
	{
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		int[][] area = new int[A.length][2];
		for (int i = 0; i < A.length; i++)
		{
			while (stack.peek() != -1 && A[i] < A[stack.peek()])
				stack.pop();
			area[i][0] = stack.peek() + 1;
			stack.add(i);
		}
		stack.clear();
		stack.add(A.length);
		for (int i = A.length - 1; i > -1; i--)
		{
			while (stack.peek() != A.length && A[i] <= A[stack.peek()])
				stack.pop();
			area[i][1] = stack.peek() - 1;
			stack.add(i);
		}
		long res = 0;
		for (int i = 0; i < A.length; i++)
		{
			int lo = area[i][0], hi = area[i][1];
			res = (res + ((hi - i + 1) * (i - lo + 1)) * A[i]) % M;
		}
		return (int) res % M;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(sumSubarrayMins(new int[] { 3, 1, 2, 4 }));

	}

}
