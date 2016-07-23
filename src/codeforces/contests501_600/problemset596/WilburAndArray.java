package codeforces.contests501_600.problemset596;

import java.util.Scanner;

public class WilburAndArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		System.out.println(solve(b));
		sc.close();
	}

	static long solve(int[] b) {
		long result = 0;
		int n = b.length;
		int[] a = new int[n];
		
		int steps = (int) Math.abs(a[0] - b[0]);
		int last = b[0];
		result += steps;
		
		for (int i = 1; i < n; i++) {
			if (last != b[i]) {
				steps = (int) Math.abs(b[i] - last);
				result += steps;
				last = b[i];
			}
		}
		return result;
	}
}
