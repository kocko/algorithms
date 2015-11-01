package hackerrank.projecteuler;

import java.util.Scanner;

public class MaximumPathSumII {

	static int[][] rows;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int t = 0; t < testCases; t++) {
			int n = sc.nextInt();
			rows = new int[n][];
			for (int i = 0; i < n; i++) {
				int[] row = new int[i + 1];
				for (int j = 0; j < i + 1; j++) {
					row[j] = sc.nextInt();
				}
				rows[i] = row;
			}
			System.out.println(calculateMaxPathSum(n));
		}
		sc.close();
	}
	
	static int calculateMaxPathSum(int n) {
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			int rowCount = rows[i].length;
			for (int j = 0; j < rowCount; j++) {
				int b = rowCount > 1 ? j % (rowCount - 1) : 0;
				if (i == 0 && b == 0) {
					dp[i][j] = rows[i][j];
				} else if (j == 0) {
					dp[i][j] = rows[i][j] + dp[i - 1][j];
				} else if (j == rowCount - 1) {
					dp[i][j] = rows[i][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = rows[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (dp[n - 1][i] > result) {
				result = dp[n - 1][i];
			}
		}
		return result;
	}
}
