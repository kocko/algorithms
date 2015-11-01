package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			int next = 0;
			for (char c : line.toCharArray()) {
				map[i][next++] = c;
			}
		}
		char[][] result = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (n > 1) {
					if (i % (n - 1) == 0 || j % (n - 1) == 0) {
						result[i][j] = map[i][j];
					} else {
						if (map[i - 1][j] < map[i][j] && map[i + 1][j] < map[i][j] &&
							map[i][j - 1] < map[i][j] && map[i][j + 1] < map[i][j]) {
							result[i][j] = 'X';
						} else {
							result[i][j] = map[i][j];
						}
					} 
				} else {
					result[i][j] = map[i][j];
				}
			}
		}
		sc.close();
		for (char[] array : result) {
			System.out.println(new String (array));
		}
	}
}
