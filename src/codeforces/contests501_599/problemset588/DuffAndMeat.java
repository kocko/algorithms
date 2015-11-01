package codeforces.contests501_599.problemset588;

import java.util.Scanner;

/**
 * Code forces - Problem 588 A
 */
public class DuffAndMeat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		int[] a = new int[days];
		int[] p = new int[days];
		for (int i = 0; i < days; i++) {
			a[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		System.out.println(minimizeCost(a, p));
		sc.close();
	}
	
	static int minimizeCost(int[] a, int[] p) {
		int n = a.length;
		int[] dp = new int[n];
		dp[0] = a[0] * p[0];
		int result = dp[0];
		int bestPrice = p[0];
		for (int i = 1; i < n; i++) {
			bestPrice = Math.min(p[i], bestPrice);
			dp[i] = a[i] * bestPrice;
			result += dp[i];
		}
		return result;
	}
}
