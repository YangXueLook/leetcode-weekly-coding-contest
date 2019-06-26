package lc0915;

public class Q2
{

	public int totalFruit(int[] tree)
	{
		if (tree.length <= 2)
			return tree.length;

		int currentIndex = 0;
		int currentACount = 0;
		int currentBCount = 0;
		int max = 0;
		int a = -1;
		int b = -1;

		while (currentIndex < tree.length)
		{
			if (currentIndex != tree.length - 1)
			{
				if (a == -1)
				{
					a = tree[currentIndex];
					currentIndex++;
					currentACount++;

				}
				else if (tree[currentIndex] == a)
				{
					currentIndex++;
					currentACount++;
				}
				else if (b == -1)
				{
					b = tree[currentIndex];
					currentIndex++;
					currentBCount++;

				}
				else if (tree[currentIndex] == b)
				{
					currentIndex++;
					currentBCount++;
				}
				else
				{
					max = Math.max(max, currentACount + currentBCount);

					int c = tree[currentIndex - 1];
					int backIndex = currentIndex - 1;
					while (backIndex > 0 && tree[backIndex] == c)
						backIndex--;
					a = c;
					b = tree[currentIndex];
					currentACount = currentIndex - backIndex;
					currentBCount = 0;
					currentIndex++;
				}
			}
			else
			{
				if (tree[currentIndex] == a || tree[currentIndex] == b)
					max = Math.max(max, currentACount + currentBCount + 1);
				else
					max = Math.max(max, currentACount + currentBCount);
				currentIndex++;
			}

		}

		return max;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
