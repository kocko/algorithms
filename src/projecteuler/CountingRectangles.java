package projecteuler;

import java.util.Scanner;

public class CountingRectangles {

	static int LIMIT;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LIMIT = sc.nextInt();
		sc.close();
		
		calculateRectangles();
	}
	
	static void calculateRectangles() {
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
				if (Math.abs(LIMIT - dp[i][j]) < min) {
					min = Math.abs(LIMIT - dp[i][j]);
					a = i;
					b = j;
				}
			}
		}
		System.out.println(a + " * " + b + " = " + (a * b));
		System.out.println(min);
		System.out.println(dp[a][b]);
	}
	
}
