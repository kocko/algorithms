package hackerrank.projecteuler;

import java.util.Scanner;

/**
 * Problem 01
 */
public class MultiplesOf3And5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			long x = sc.nextLong();
			System.out.println(count(x - 1));
		}
		sc.close();
	}
	
	static long count(long x) {
		long threeLimit = x - x % 3;
		long fiveLimit = x - x % 5;
		long fifteenLimit = x - x % 15;
		return calculate(3, threeLimit / 3) + calculate(5, fiveLimit / 5) - calculate(15, fifteenLimit / 15);
	}
	
	static long calculate(long multiplier, long limit) {
		if (limit != 0) {
			return multiplier * (limit + 1) * limit / 2;
		}
		return 0;
	}
}
