package hackerrank.algorithms.dynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	static BigInteger[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
		dp = new BigInteger[n];
		dp[0] = new BigInteger(a + "");
		dp[1] = new BigInteger(b + "");
		sc.close();
		fillFibonacciModified(n);
		System.out.println(dp[n - 1]);
	}

	static void fillFibonacciModified(int n) {
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1].pow(2).add(dp[i - 2]);
		}
	}
}
