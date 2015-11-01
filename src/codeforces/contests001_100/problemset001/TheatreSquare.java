package codeforces.contests001_100.problemset001;

import java.util.Scanner;

public class TheatreSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a = sc.nextInt();
		System.out.println(calculate(n, a) * calculate(m, a));
		sc.close();
	}

	static long calculate(int n, int a) {
		long result = 1;
		if (a <= n) {
			result = n / a;
			if (n % a > 0) {
				result++;
			}
		}
		return result;
	}
	
}
