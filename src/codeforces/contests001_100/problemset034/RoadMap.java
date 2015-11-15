package codeforces.contests001_100.problemset034;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadMap { 

	static int n;
	static int[] newParentMap;
	
	static boolean[] visited;
	static List<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		newParentMap = new int[n + 1];
		visited = new boolean[n + 1];
		
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		int root = sc.nextInt();
		int newRoot = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			if (i != root) {
				int c = sc.nextInt();
				graph[i].add(c);
				graph[c].add(i);
			}
		}
		sc.close();
		
		dfs(newRoot, -1);

		for (int i = 1; i <= n; i++) {
			if (i != newRoot) {
				System.out.print(newParentMap[i] + " ");
			}
		}
	}

	static void dfs(int vertice, int parent) {
		newParentMap[vertice] = parent;
		visited[vertice] = true;
		for (int i = 0; i < graph[vertice].size(); i++) {
			int x = graph[vertice].get(i);
			if (!visited[x]) {
				dfs(x, vertice);
			}
		}
	}

}
