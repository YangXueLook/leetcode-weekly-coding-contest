package lc0427;

import java.util.HashSet;

public class Q2
{
	int extraColor = 1001;

	HashSet<Integer> visited = new HashSet<Integer>();

	public int[][] colorBorder(int[][] grid, int r0, int c0, int color)
	{
		int originalColor = grid[r0][c0];
		dfs(grid, r0, c0, originalColor, color);

		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == extraColor)
					grid[i][j] = originalColor;
		}

		return grid;
	}

	private void dfs(int[][] grid, int r, int c, int originalColor, int color)
	{
		if (!visited.contains(r * 100 + c))
		{
			visited.add(r * 100 + c);

			grid[r][c] = extraColor;
			if (r == 0 || r == grid.length - 1 || c == 0
					|| c == grid[0].length - 1)
				grid[r][c] = color;
			else if ((grid[r + 1][c] != originalColor && !visited
					.contains((r + 1) * 100 + c))
					|| (grid[r - 1][c] != originalColor && !visited
							.contains((r - 1) * 100 + c))
					|| (grid[r][c + 1] != originalColor && !visited.contains(r
							* 100 + c + 1))
					|| (grid[r][c - 1] != originalColor && !visited.contains(r
							* 100 + c - 1)))
				grid[r][c] = color;
			if (r < grid.length - 1 && grid[r + 1][c] == originalColor)
				dfs(grid, r + 1, c, originalColor, color);
			if (r > 0 && grid[r - 1][c] == originalColor)
				dfs(grid, r - 1, c, originalColor, color);
			if (c < grid[0].length - 1 && grid[r][c + 1] == originalColor)
				dfs(grid, r, c + 1, originalColor, color);
			if (c > 0 && grid[r][c - 1] == originalColor)
				dfs(grid, r, c - 1, originalColor, color);
		}

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
