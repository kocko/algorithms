package codeforces.contests001_100.problemset037;

import java.util.Scanner;

public class Towers {

	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] blocks = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			blocks[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(solve(blocks));
	}
	
	static String solve(int[] blocks) {
		int[] heights = new int[1001];
		for (int i = 1; i <= n; i++) {
			heights[blocks[i]]++;
		}
		int total = 0;
		int max = 0;
		for (int i = 0; i < 1001; i++) {
			if (heights[i] > 0) total++;
			if (heights[i] > max) {
				max = heights[i];
			}
		}
		return max + " " + total;
	}
	
}
