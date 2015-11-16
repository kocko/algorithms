package codeforces.contests501_599.problemset596;

import java.util.Scanner;

public class WilburAndSwimmingPool {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] points = new int[n][2];
		for (int i = 0; i < n; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		int result = solve(n, points);
		System.out.println(result);
		sc.close();
	}
	
	static int solve(int n, int[][] points) {
		if (n < 2) return -1;
		if (n == 2) {
			if ((points[0][0] == points[1][0]) || points[0][1] == points[1][1]) {
				return -1;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((points[i][0] != points[j][0]) && (points[i][1] != points[j][1])) {
					return (int) (Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
				}
			}
		}
		return 0;
	}
}
