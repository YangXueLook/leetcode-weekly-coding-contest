package lc1006;

public class Q4
{
	
	
//	Your music player contains N different songs and she wants to listen to L (not necessarily different) songs during your trip.  You create a playlist so that:
//
//	    Every song is played at least once
//	    A song can only be played again only if K other songs have been played
//
//	Return the number of possible playlists.  As the answer can be very large, return it modulo 10^9 + 7.
	
	
	
	
	
	// F(N,L,K) = F(N - 1, L - 1, K) * N + F(N, L - 1, K) * (N - K)
	//
	// F(N - 1, L - 1, K)
	// If only N - 1 in the L - 1 first songs.
	// We need to put the rest one at the end of music list.
	// Any song can be this last song, so there are N possible combinations.
	//
	// F(N, L - 1, K)
	// If already N in the L - 1 first songs.
	// We can put any song at the end of music list,
	// but it should be different from K last song.
	// We have N - K choices.
	//
	// Time Complexity:
	// O((L-K)(N-K))

	long mod = (long) 1e9 + 7;

	public int numMusicPlaylists(int N, int L, int K)
	{
		long[][] dp = new long[N + 1][L + 1];
		for (int i = K + 1; i <= N; ++i)
			for (int j = i; j <= L; ++j)
				if ((i == j) || (i == K + 1))
					dp[i][j] = factorial(i);
				else
					dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - K))
							% mod;
		return (int) dp[N][L];
	}

	long factorial(int n)
	{
		return n > 0 ? factorial(n - 1) * n % mod : 1;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
