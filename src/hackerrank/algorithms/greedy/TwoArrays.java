package hackerrank.algorithms.greedy;

import java.util.Scanner;

public class TwoArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			fillArray(sc, a);
			fillArray(sc, b);
			System.out.println(solve(a, b, k));
		}
		sc.close();
	}

	static void fillArray(Scanner sc, int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
	}

	static String solve(int[] a, int[] b, int k) {
		int n = a.length;
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; i++) {
			int candidate = Integer.MAX_VALUE;
			int candidateIndex = -1;
			for (int j = 0; j < n; j++) {
				if (a[i] + b[j] >= k && !used[j]) {
					if (b[j] < candidate) {
						candidate = b[j];
						candidateIndex = j;
					}
				}
			}
			if (candidate == Integer.MAX_VALUE) {
				return "NO";
			} else {
				used[candidateIndex] = true;
			}
		}
		return "YES";
	}
}
