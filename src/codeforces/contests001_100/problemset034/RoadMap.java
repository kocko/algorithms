package codeforces.contests001_100.problemset034;

import java.util.Scanner;

public class RoadMap {

	static int n;
	static int[] parentMap;
	static int[] newParentMap;
	static boolean[] visited;
	int[][] x = new int[50000][50000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		parentMap = new int[n + 1];
		newParentMap = new int[n + 1];
		visited = new boolean[n + 1];

		int root = sc.nextInt();
		parentMap[root] = 0;

		int newRoot = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i != root) {
				parentMap[i] = sc.nextInt();
			} else {
				parentMap[i] = -1;
			}
		}

		newParentMap[newRoot] = -1;
		dfs(newRoot);

		for (int i = 1; i <= n; i++) {
			if (i != newRoot) {
				System.out.print(newParentMap[i] + " ");
			}
		}
		sc.close();
	}

	static void dfs(int vertice) {
		for (int i = 1; i <= n; i++) {
			if (parentMap[i] == vertice && !visited[i]) {
				newParentMap[i] = vertice;
				visited[i] = true;
				dfs(i);
			}
		}

		int predcestor = parentMap[vertice];
		if (predcestor > 0 && !visited[predcestor]) {
			visited[predcestor] = true;
			newParentMap[predcestor] = vertice;
			dfs(predcestor);
		}
		
	}

}
