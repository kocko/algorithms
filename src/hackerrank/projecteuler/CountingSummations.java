package hackerrank.projecteuler;

import java.math.BigInteger;
import java.util.Scanner;

public class CountingSummations {

	static int MAX = 1000;

	static BigInteger[][] dp = new BigInteger[MAX + 1][MAX + 1];

	public static void main(String[] args) {
		fillGrid();
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			System.out.println((dp[n][n].add(new BigInteger("-1"))).mod(new BigInteger("1000000007")));
		}
		sc.close();
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
