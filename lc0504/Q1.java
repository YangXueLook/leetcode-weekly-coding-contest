package lc0504;

public class Q1
{
	public boolean isBoomerang(int[][] points)
	{
		if (points[0][0] == points[1][0] && points[2][0] == points[1][0])
			return false;

		int x = points[1][0] - points[0][0];
		int y = points[1][1] - points[0][1];
		int z = points[2][0] - points[1][0];
		int w = points[2][1] - points[1][1];

		return !(x * w == y * z);
	}

	public boolean isRobotBounded(String instructions)
	{
		// int direction = 0;
		int x = 0;
		int y = 0;
		int currentDirection = 0;

		for (int i = 0; i < instructions.length(); i++)
		{
			if (instructions.charAt(i) == 'L')
			{

				currentDirection = (currentDirection + 1) % 4;
			}

			else if (instructions.charAt(i) == 'R')
			{

				currentDirection = (currentDirection - 1 + 4) % 4;
			}
			else
			{
				if (currentDirection == 0)
					y++;
				else if (currentDirection == 1)
					x--;
				else if (currentDirection == 2)
					y--;
				else if (currentDirection == 3)
					x++;
			}

		}

		return currentDirection != 0 || (x == 0 && y == 0);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
