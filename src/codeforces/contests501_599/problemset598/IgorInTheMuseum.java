package codeforces.contests501_599.problemset598;

import java.util.Scanner;

public class IgorInTheMuseum {
	
	static int N, M;
	
	static char[][] museum;
	
	static boolean[][] used;
	
	static boolean[][] initUsed() {
		used = new boolean[N + 1][M + 1];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < M + 1; j++) {
				if ((i == 0 || j == 0) || (i == N || j == M)) {
					used[i][j] = true;
					continue;
				}
				if (museum[i][j] == '*') {
					used[i][j] = true;
				}
			}
		}
		return used;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		museum = new char[N][M];
		int k = sc.nextInt();
		for (int i = 0; i < N; i++) { 
			char[] row = sc.next().toCharArray();
			museum[i] = row;
		}
		for (int i = 0; i < k; i++) {
			initUsed();
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(dfs(x, y));
		}
		sc.close();
	}
	
	static int dfs(int x, int y) {
		return 0;
	}
}
