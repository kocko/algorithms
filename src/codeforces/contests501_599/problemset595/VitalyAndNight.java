package codeforces.contests501_599.problemset595;

import java.util.Scanner;

public class VitalyAndNight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < 2 * m; i += 2) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				if (first == 1 || second == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
	
}
