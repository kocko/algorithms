package hackerrank.projecteuler;

import java.util.Scanner;

public class CountingRectangles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int limit = sc.nextInt();
			calculateRectangles(limit);
		}
		sc.close();
	}
	
	static void calculateRectangles(int limit) {
		int[][] dp = new int[1001][1001];
		dp[1][1] = 1;
		int min = Integer.MAX_VALUE;
		int a = 0, b = 0;
		for (int i = 1; i < 1001; i++) {
			for (int j = i; j < 1001; j++) {
				if (i == 1) {
					dp[1][j] = j + dp[1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j] + i * (j + 1) * j / 2;
				}
				int abs = Math.abs(limit - dp[i][j]) ;
				if (abs < min) {
					min = abs;
					a = i;
					b = j;
				} else if (abs == min) {
					if (i * j > a * b) {
						a = i;
						b = j;
					}
				}
			}
		}
		System.out.println(a * b);
	}
}
