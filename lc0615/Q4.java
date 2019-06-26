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
public class Q4
{

	public String shortestCommonSupersequence(String s1, String s2)
	{
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++)
			dp[i][0] = i;
		for (int j = 1; j <= s2.length(); j++)
			dp[0][j] = j;

		for (int i = 1; i <= s1.length(); i++)
		{
			for (int j = 1; j <= s2.length(); j++)
			{
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				else
				{
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuffer sb = new StringBuffer();

		int i = s1.length(), j = s2.length();
		while (i > 0 && j > 0)

		{
			if (s1.charAt(i - 1) == s2.charAt(j - 1))
			{
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			}

			else if (dp[i - 1][j] > dp[i][j - 1])
			{
				sb.append(s2.charAt(j - 1));
				j--;
			}
			else
			{
				sb.append(s1.charAt(i - 1));
				i--;
			}
		}

		while (i > 0)
		{
			sb.append(s1.charAt(i - 1));
			i--;
		}

		while (j > 0)
		{
			sb.append(s2.charAt(j - 1));
			j--;
		}

		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// System.out.println(shortestCommonSupersequence("abac", "cba"));

	}

}
