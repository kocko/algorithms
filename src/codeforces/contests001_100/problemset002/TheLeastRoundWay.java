package codeforces.contests001_100.problemset002;

import java.util.Scanner;

import static java.lang.Math.min;

public class TheLeastRoundWay {

	static int n;
	static int[][] input;
	
	static String[][] ways;
	static int[][][] dp;

	public static void main(String[] args) {
		readInput();
		initWays();
		findLeastRoundWay();
	}

	static void readInput() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[n][n];
		ways = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}

	static void initWays() {
		ways[0][0] = "";
		for (int i = 1; i < n; i++) {
			ways[0][i] = ways[0][i - 1] + "R";
			ways[i][0] = ways[i - 1][0] + "D";
		}
		dp = new int[n][n][2];
	}

	static void findLeastRoundWay() {
		dp[0][0][0] = findPower(input[0][0], 2);
		dp[0][0][1] = findPower(input[0][0], 5);
		for (int i = 1; i < n; i++) {
			
		}
	}
	
	static int findPower(int n, int k) {
		int result = 0;
		if (n == 0) return 1;
		while (n % k == 0) {
			result++;
			n /= k;
		}
		return result;
	}
}
