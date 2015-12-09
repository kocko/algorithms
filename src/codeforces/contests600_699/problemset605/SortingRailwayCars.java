package codeforces.contests600_699.problemset605;

import java.util.Scanner;

public class SortingRailwayCars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		int left = list[0], right = list[n - 1], result = 0;
		for (int i = 0; i < n; i++) {
			if (list[i] < left) {
				left = list[i];
//				if (i == n - 1) right = list[i - 1];
				result++;
			} else if (list[i] > right) {
				right = list[i];
				if (i == 0) left = list[i + 1];
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}
	
}
