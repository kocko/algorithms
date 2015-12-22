package codeforces.contests501_599.problemset583;

import java.util.Scanner;

public class AsphaltingRoads {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] h = new boolean[n + 1];
		boolean[] w = new boolean[n + 1];
		for (int i = 1; i <= n * n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (!h[x] && !w[y]) {
				h[x] = true;
				w[y] = true;
				System.out.print(i + " ");
			}
		}
		sc.close();
	}
	
}
