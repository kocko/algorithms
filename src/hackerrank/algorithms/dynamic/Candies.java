package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class Candies {

	static int[] dp;

	static int[] rating;

	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n];
		rating = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			rating[i] = sc.nextInt();
		}
		sc.close();

		System.out.println(minimizeCandies());
	}

	static int minimizeCandies() {
		int total = 0;
		for (int i = 1; i < n; i++) {
			if (rating[i] > rating[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else if (rating[i] < rating[i - 1] && dp[i] == dp[i - 1]) {
				back: for (int j = i; j >= 1; j--) {
					if (rating[j - 1] > rating[j]) {
						if (dp[j] >= dp[j - 1])
							dp[j - 1] = dp[j] + 1;
					} else
						break back;
				}
			}
		}
		for (int i : dp) {
			total += i;
		}
		return total;
	}

}
