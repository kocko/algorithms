package codeforces.contests001_100.problemset002;

import java.util.Scanner;

import static java.lang.Math.min;

public class TheLeastRoundWay {

	static int n;
	static int[][] input;

    static int[][][] dp;
    static String[][] path;

    static boolean zero;
    static int zeroX, zeroY;

	public static void main(String[] args) {
		readInput();
		init();
		findLeastRoundWay();
	}

	static void readInput() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = sc.nextInt();
                if (input[i][j] == 0) {
                    zero = true;
                    zeroX = j; zeroY = i;
                    input[i][j] = 10;
                }
			}
		}
		sc.close();
	}

    static void init() {
        dp = new int[n][n][2];
        path = new String[n][n];
    }

    static void findLeastRoundWay() {
        dp[0][0][0] = divCount(input[0][0], 2);
        dp[0][0][1] = divCount(input[0][0], 5);
        path[0][0] = "";
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + divCount(input[i][0], 2);
            dp[i][0][1] = dp[i - 1][0][1] + divCount(input[i][0], 5);
            path[i][0] = path[i - 1][0] + "D";
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + divCount(input[0][i], 2);
            dp[0][i][1] = dp[0][i - 1][1] + divCount(input[0][i], 5);
            path[0][i] = path[0][i - 1] + "R";
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int twos = divCount(input[i][j], 2);
                int fives = divCount(input[i][j], 5);
                int x = min(dp[i - 1][j][0] + twos, dp[i - 1][j][1] + fives);
                int y = min(dp[i][j - 1][0] + twos, dp[i][j - 1][1] + fives);
                if (x <= y) {
                    dp[i][j][0] = dp[i - 1][j][0] + twos;
                    dp[i][j][1] = dp[i - 1][j][1] + fives;
                    path[i][j] = path[i - 1][j] + "D";
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + twos;
                    dp[i][j][1] = dp[i][j - 1][1] + fives;
                    path[i][j] = path[i][j - 1] + "R";
                }
            }
        }
        int result = min(dp[n - 1][n - 1][0], dp[n - 1][n - 1][1]);
        if (zero && result > 1) {
            System.out.println(1);
            findZeroWay();
        } else {
            System.out.println(result);
            System.out.println(path[n - 1][n - 1]);
        }
    }

    static int divCount(int n, int k) {
        int result = 0;
        while (true) {
            if (n % k == 0) {
                n /= k;
                result++;
            } else break;
        }
        return result;
    }

    static void findZeroWay() {
        for (int i = 0; i < zeroX; i++) {
            System.out.print("R");
        }
        for (int j = 1; j < n; j++) {
            System.out.print("D");
        }
        for (int i = zeroX + 1; i < n; i++) {
            System.out.print("R");
        }
    }

}
