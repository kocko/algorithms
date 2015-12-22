package codeforces.contests600_699.problemset605;

import java.util.Scanner;

public class SortingRailwayCars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] temp = new int[n + 1];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			temp[next] = temp[next - 1] + 1;
			max = Math.max(max, temp[next]);
		}
		sc.close();
		
		System.out.println(n - max);
	}
	
}
