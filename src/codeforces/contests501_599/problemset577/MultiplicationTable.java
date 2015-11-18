package codeforces.contests501_599.problemset577;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long x = sc.nextLong();
		System.out.println(countOccurences(n, x));
		sc.close();
	}
	
	static long countOccurences(long n, long x) {
		if (x > n * n) return 0L;
		
		long result = 0L;
		for (long i = 1; i <= n; i++) {
			if (x % i == 0) {
				long rem = x / i;
				if (rem <= n) result++; 
			}
		}
		return result;
	}
	
}
