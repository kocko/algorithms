package codeforces.contests501_600.problemset588;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuffInLove {
	final static int LIMIT = 100001;
	
	static boolean[] sieve = new boolean[LIMIT];
	
	static void fillSieve() {
		int max = (int) Math.sqrt(Integer.MAX_VALUE);
		sieve[0] = sieve[1] = false;
		for (int i = 2; i < Math.sqrt(max); i++) {
			int square = i * i;			
			if (square >= LIMIT) break;
			for (int j = square; j <= LIMIT; j += square) {
				sieve[j] = true;
			}
		}
	}

	public static void main(String[] args) {
		fillSieve();
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(findLovelyNumber(n));
		sc.close();
	}
	
	static long findLovelyNumber(long n) {
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				long candidate = n / i;
				if (isLovelyNumber(candidate)) {
					return candidate;
				}
			}
		}
		return -1;
	}
	
	static Set<Long> findDivisors(long n) {
		Set<Long> result = new TreeSet<>();
		result.add(1L);
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				result.add(i);
			}
			if (i != n / i) {
				result.add(n / i);
			}
		}
		result.add(n);
		return result;
	}
	
	static boolean isLovelyNumber(long n) {
		return !sieve[(int) n];
	}
	
}
