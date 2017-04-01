package topcoder.tco.tco2017.round1;

import java.util.Arrays;

import static java.lang.Math.max;

public class CheeseSlicing {
	
	public int totalArea(int a, int b, int c, int s) {
		this.s = s;
		init();
		return recurse(a, b, c);
	}

	private int s;
	private int[][][] dp = new int[101][101][101];
	
	private void init() {
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
	}

	private int recurse(int a, int b, int c) {
		if (a > b) {
			int t = a;
			a = b;
			b = t;
		}
		if (a > c) {
			int t = a;
			a = c;
			c = t;
		}
		if (a < s) {
			return 0;
		}
		if (b > c) {
			int t = b;
			b = c;
			c = t;
		}
		if (dp[a][b][c] >= 0) {
			return dp[a][b][c];
		}
		int result = b * c;
		for (int i = 1; i < a; i++) {
			result = max(result, recurse(a - i, b, c) + recurse(i, b, c));
		}
		for (int i = 1; i < b; i++) {
			result = max(result, recurse(a, b - i, c) + recurse(a, i, c));
		}
		for (int i = 1; i < c; i++) {
			result = max(result, recurse(a, b, c - i) + recurse(a, b, i));
		}
		dp[a][b][c] = result;
		return result;
	}
	
}
