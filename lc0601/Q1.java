/**
 * lookiYang Xue
 * TODO
 * Jun 1, 2019
 * 2019
 */
package lc0601;

/**
 * @author looki
 * 
 */
public class Q1
{
	public String gcdOfStrings(String s1, String s2)
	{

		int len = Math.min(s1.length(), s2.length());
		int maxLen = 0;
		for (int i = 1; i <= len; i++)
		{
			String sub = s1.substring(0, i);
			if (isDivider(sub, s1) && isDivider(sub, s1))
				maxLen = Math.max(maxLen, i);
		}

		return s1.substring(0, maxLen);
	}

	/**
	 * @param sub
	 * @param s1
	 * @return
	 */
	private boolean isDivider(String sub, String s1)
	{
		if (s1.length() % sub.length() != 0)
			return false;
		int times = s1.length() / sub.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < times; i++)
		{
			sb.append(sub);
		}

		return s1.equals(sb.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
