package codeforces.contests501_599.problemset589;

import java.util.Scanner;

/**
 * Code forces - Problem 589 I
 */
public class Lottery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] colors = new int[k + 1];
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			colors[next]++;
		}
		System.out.println(minimizeRepaint(colors, n, k));
		sc.close();
	}

	private static int minimizeRepaint(int[] colors, int n, int k) {
		int result = 0;
		int limit = n / k;
		for (int i = 1; i < k + 1; i++) {
			result += Math.abs(colors[i] - limit);
		}
		return result / 2;
	}

}
