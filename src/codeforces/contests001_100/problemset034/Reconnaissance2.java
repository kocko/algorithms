package codeforces.contests001_100.problemset034;

import java.util.Scanner;

/**
 * Code forces - Problem 34 A
 */
public class Reconnaissance2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] soldiers = new int[n];
		for (int i = 0; i < n; i++) {
			soldiers[i] = sc.nextInt();
		}
		int minimal = Math.abs(soldiers[0] - soldiers[n - 1]);
		int resultX = 1, resultY = n;
		for (int i = 1; i < n; i++) {
			int score = Math.abs(soldiers[i] - soldiers[i - 1]);
			if (score < minimal) {
				minimal = score;
				resultX = i + 1;
				resultY = i;
			}
		}
		System.out.println(resultX + " " + resultY);
		sc.close();
	}

}
