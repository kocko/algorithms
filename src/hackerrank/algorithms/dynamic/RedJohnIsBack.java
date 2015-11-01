package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class RedJohnIsBack {

	static int[] values = { 1, 4 };

	static long[] dp = new long[41];

	static int LIMIT = 220000;

	static boolean[] sieve = new boolean[LIMIT];

	static void fillSieve() {
		int crosslimit = (int) Math.sqrt(LIMIT);
		for (int i = 2; i < LIMIT; i += 2) {
			sieve[i] = true;
		}
		sieve[2] = false;
		for (int i = 3; i <= crosslimit; i += 2) {
			if (!sieve[i]) {
				for (int j = i * i; j < LIMIT; j += i) {
					sieve[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		fillSieve();
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			dp[0] = dp[1] = dp[2] = dp[3] = 1;
			int count = 0;
			long sums = splitNIntoSumOfValues(n);
			for (int j = 2; j <= sums; j++) {
				if (!sieve[j])
					count++;
			}
			System.out.println(count);
		}
		sc.close();
	}

	static long splitNIntoSumOfValues(int n) {
		if (n < 4) {
			return 1;
		} else {
			for (int i = 4; i <= 40; i++) {
				dp[i] = dp[i - 1] + dp[i - 4];
			}
		}
		return dp[n];
	}
}
