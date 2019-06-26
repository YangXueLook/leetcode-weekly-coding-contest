package lc0406;

import java.util.Arrays;
import java.util.Comparator;

public class Q4
{

	public static int videoStitching(int[][] clips, int T)
	{
		Arrays.sort(clips, new Comparator<int[]>()
		{

			@Override
			public int compare(int[] o1, int[] o2)
			{
				if (o1[0] == o2[0])
					return o2[1] - o1[1];
				else
					return o1[0] - o2[0];
			}

		});
		
		for(int[] a: clips)
			System.out.println(a[0] + "\t" + a[1]);
		
		System.out.println("--------------");
		
		if(clips[0][0] != 0)
			return -1;
		
		int start = clips[0][0];
		int end = clips[0][1];
		if(end >= T)
			return 1;
		
		int nextEnd = end;
		int count = 1;
		for(int i = 1; i < clips.length; i++)
		{
			System.out.println(end + "\t" + nextEnd);
			
			if(i == clips.length - 1)
			{
				if(clips[i][0] <= end)
				{
					if(clips[i][1] >= T)
						return count + 1;
					else
						return -1;
				}
				else if(clips[i][0] <= nextEnd)
				{
					count++;
					if(clips[i][1] >= T)
						return count + 1;
					else
						return -1;
				}
				else return -1;
			}
			
			
			if(clips[i][0] <= end)
			{
				nextEnd = Math.max(nextEnd, clips[i][1]);
				if(nextEnd >= T)
					return count + 1;
			}
			else
			{
				end = nextEnd;
				count++;
				
				if(clips[i][0] > end)
					return -1;
				
			}
		}
		

		return -1;
	}

	public static void main(String[] args)
	{
		int[][] a = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
		videoStitching(a, 10);
		
		// TODO Auto-generated method stub

	}

}
