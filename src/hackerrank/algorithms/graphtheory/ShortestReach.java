package hackerrank.algorithms.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestReach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int nodes = sc.nextInt();
			int vertices = sc.nextInt();
			int[][] matrix = new int[nodes + 1][nodes + 1];
			for (int j = 0; j < vertices; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				matrix[start][end] = matrix[end][start] = 6;
			}
			int start = sc.nextInt();
			int[] result = bfs(start, matrix);
			for (int k = 1; k <= nodes; k++) {
				if (start != k) {
					System.out.print((result[k] == 0 ? -1 : result[k]) + " ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
	
	@SuppressWarnings("serial")
	static int[] bfs(final int start, int[][] matrix) {
		int n = matrix.length - 1;
		int[] result = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		List<Integer> startIndices = new ArrayList<Integer>() {{ add(start); }};
		int p = 1;
		while (!startIndices.isEmpty()) {
			List<Integer> neighbours = new ArrayList<>();
			for (Integer i : startIndices) {
				for (int k = 1; k <= n; k++) {
					if (matrix[i][k] > 0 && !visited[k]) {
						visited[k] = true;
						result[k] += p * matrix[i][k];
						neighbours.add(k);
					}
				}
			}
			startIndices = neighbours;
			p++;
		}
		return result;
	}
}
