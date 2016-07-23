package codeforces.contests501_600.problemset597;

import java.util.Scanner;

public class Divisibility {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(findKDivisibleCount(k, a, b));
		sc.close();
	}

	static long findKDivisibleCount(long k, long a, long b) {
		long result = 0;
		long modulo = Math.abs(a % k);
		if (modulo != 0) {
			if (a < 0) {
				a += modulo;
			} else {
				a += (k - modulo);
			}
		}
		modulo = Math.abs(b % k);
		if (modulo != 0) {
			if (b > 0) {
				b -= modulo;
			} else {
				b -= (k - modulo);
			}
		}
		if (a > b) return 0;
		long x = countZeroToMod(a, k);
		long y = countZeroToMod(b, k);
		if (a < 0 && b > 0) {
			result = x + y + 1;
		} else {
			result = Math.abs(y - x) + 1;
		}
		return result;
	}
	
	static long countZeroToMod(long x, long k) {
		x = Math.abs(x);
		return x / k;
	}

}
