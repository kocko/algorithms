package codeforces.contests600_699.problemset604;

import java.util.Scanner;

public class MoreCowbell {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		int res = s[n - 1];
		int i = 0, j = 2 * (n - k) - 1;
		while (i <= j) {
			res = Math.max(res, s[i] + s[j]);
			i++; j--;
		}
		System.out.println(res);
		sc.close();
	}
	
}
