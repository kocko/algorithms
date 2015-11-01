package projecteuler;

import java.util.Scanner;

public class PathSumTwoWays {
	
	static final int MAX = 80;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[MAX][MAX];
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println(calculateMinPath(matrix));
	}
	
	static int calculateMinPath(int[][] matrix) {
		int[][] dp = new int[MAX][MAX];
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = matrix[i][j];
				} else if (i == 0) {
					dp[i][j] = matrix[i][j] + dp[i][j - 1];
				} else if (j == 0) { 
					dp[i][j] = matrix[i][j] + dp[i - 1][j];
				}else {
					dp[i][j] += matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[MAX - 1][MAX - 1];
	}
}
 