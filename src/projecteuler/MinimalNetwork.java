package projecteuler;

import java.util.Scanner;

/*
 * Sample input:
-,16,12,21,-,-,-
16,-,-,17,20,-,-
12,-,-,28,-,31,-
21,17,28,-,18,19,23
-,20,-,18,-,-,11
-,-,31,19,-,-,27
-,-,-,23,11,27,-
 */
public class MinimalNetwork {

	static int MAX = 40;

	static String[][] matrix = new String[MAX][MAX];

	static int totalWeight = 0;

	public static void main(String[] args) {
		readInput();
		int minimumWeight = prim();
		System.out.println(totalWeight - minimumWeight);
	}

	static void readInput() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < MAX; i++) {
			String[] line = sc.nextLine().split(",");
			for (int j = 0; j < MAX; j++) {
				matrix[i][j] = line[j];
				if (j >= i && !"-".equals(line[j])) {
					totalWeight += Integer.parseInt(line[j]);
				}
			}
		}
		sc.close();
	}

	static int prim() {
		boolean[] visited = new boolean[MAX];
		visited[0] = true;
		int result = 0;
		while (!allAreVisited(visited)) {
			int candidate = -1;
			int weight = Integer.MAX_VALUE;
			for (int i = 0; i < MAX; i++) {
				if (visited[i]) {
					for (int j = 0; j < MAX; j++) {
						if (!visited[j] && !"-".equals(matrix[i][j])) {
							if (Integer.parseInt(matrix[i][j]) < weight) {
								candidate = j;
								weight = Integer.parseInt(matrix[i][j]);
							}
						}
					}
				}
			}
			visited[candidate] = true;
			result += weight;
		}

		return result;
	}

	static boolean allAreVisited(boolean[] visited) {
		for (boolean b : visited) {
			if (!b)
				return false;
		}
		return true;
	}
}
