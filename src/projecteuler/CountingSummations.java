package projecteuler;

public class CountingSummations {

	static long[][] dp = new long[101][101];

	public static void main(String[] args) {
		System.out.println(count(100));
	}

	static long count(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1) {
					dp[i][j] = 1;
				} else if (j == 1) {
					dp[i][j] = 1;
				} else if (i < j) {
					dp[i][j] = dp[i][i];
				} else if (i == j) {
					dp[i][j] = 1 + dp[i][i - 1];
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - j][j];
				}
			}
		}
		return dp[n][n] - 1;
	}
}
