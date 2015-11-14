package codeforces.contests501_599.problemset598;

import java.util.Scanner;

public class TrickySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			long n = sc.nextLong();
			System.out.println(calculateTrickySum(n));
		}
		sc.close();
	}

	static long calculateTrickySum(long n) {
		int limit = log2(n);
		return (n * (n + 1) - (1l << limit + 3) + 4) >> 1;
	}

	static int log2(long x) {
		return (int) (Math.log10(x) / Math.log10(2));
	}
	
}
