package projecteuler;

import java.math.BigInteger;

public class CoinPartitions {

	static int MAX = 1000;

	static BigInteger[][] dp = new BigInteger[MAX + 1][MAX + 1];

	public static void main(String[] args) {
		fillGrid();
		for (int i = 1; i <= MAX; i++) {
			if (dp[i][i].toString().endsWith("000000")) {
				System.out.println(i + "<--------------");
				break;
			}
		}
	}

	static void fillGrid() {
		for (int i = 1; i <= MAX; i++) {
			for (int j = 1; j <= MAX; j++) {
				if (i == 1) {
					dp[i][j] = BigInteger.ONE;
				} else if (j == 1) {
					dp[i][j] = BigInteger.ONE;
				} else if (i < j) {
					dp[i][j] = dp[i][i];
				} else if (i == j) {
					dp[i][j] = BigInteger.ONE.add(dp[i][i - 1]);
				} else {
					dp[i][j] = dp[i][j - 1].add(dp[i - j][j]);
				}
			}
		}
	}
}
