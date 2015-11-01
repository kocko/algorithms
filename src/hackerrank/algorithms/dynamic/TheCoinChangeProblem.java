package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class TheCoinChangeProblem {
	static int[] coins;

	static int n;

	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n + 1][n + 1];
		int coinsNumber = sc.nextInt();
		coins = new int[coinsNumber];
		for (int i = 0; i < coinsNumber; i++) {
			coins[i] = sc.nextInt();
		}
		System.out.println(findCoinChangeWays());
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	static int findCoinChangeWays() {
		int maxCoin = -1;
		for (int i : coins) {
			if (i > maxCoin) {
				maxCoin = i;
			}
		}
		return f(n, maxCoin);
	}

	static int f(int sum, int max) {
		if (sum <= 0) {
			return 0;
		}
		if (dp[sum][max] > 0) {
			return dp[sum][max];
		} else {
			if (sum < max) {
				max = sum;
			}
			if (sum == max && existsCoin(max)) {
				dp[sum][max] = 1;
			}
			for (int i = 0; i < coins.length; i++) {
				dp[sum][max] += f(sum - coins[i], coins[i]);
			}
		}
		return dp[sum][max];
	}

	static boolean existsCoin(int value) {
		for (int i : coins) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}

}
