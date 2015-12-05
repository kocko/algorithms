package codeforces.contests600_699.problemset604;

import java.util.Scanner;

public class UncowedForces {

	static int[] max = { 500, 1000, 1500, 2000, 2500 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] times = new int[5];
		int[] res = new int[5];
		for (int i = 0; i < 5; i++) {
			times[i] = sc.nextInt();
		}
		for (int i = 0; i < 5; i++) {
			res[i] = sc.nextInt();
		}
		int success = sc.nextInt();
		int fail = sc.nextInt();
		int score = 0;
		for (int i = 0; i < 5; i++) {
			double a = 3 * max[i] / 10.0;
			double b = (250 * max[i] - (times[i] * max[i]) - 12500 * res[i]) / 250.0;
			score += Math.max(a, b);
		}
		System.out.println(score + (100 * success) - (50 * fail));
		sc.close();
	}
	
}
