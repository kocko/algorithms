package projecteuler;

import java.util.Scanner;

public class MaximumPathSumII {

	static final int ROWS = 100;

	static int[][] rows = new int[ROWS][];

	public static void main(String[] args) {
		readInput();
		System.out.println(calculateMaxPathSum());
	}

	static void readInput() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ROWS; i++) {
			int[] row = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				row[j] = sc.nextInt();
			}
			rows[i] = row;
		}
		sc.close();
	}
	
	static int calculateMaxPathSum() {
		int[][] dp = new int[ROWS][ROWS];
		for (int i = 0; i < ROWS; i++) {
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
		for (int i = 0; i < ROWS; i++) {
			if (dp[ROWS - 1][i] > result) {
				result = dp[ROWS - 1][i];
			}
		}
		return result;
	}
}
