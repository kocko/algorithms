package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			System.out.println(calculateTreeHeight(n));
		}
		sc.close();
	}
	
	static long calculateTreeHeight(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				result *= 2;
			} else {
				result++;
			}
		}
		return result;
	}
	
}
