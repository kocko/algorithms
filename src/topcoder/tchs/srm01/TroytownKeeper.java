package topcoder.tchs.srm01;

import java.util.Arrays;

public class TroytownKeeper {
	
	public int limeLiters(String[] maze) {
		n = maze.length;
		m = maze[0].length();
		this.maze = new char[n + 2][m + 2];
		this.visited = new boolean[n + 2][m + 2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(this.maze[i], '.');
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				this.maze[i + 1][j + 1] = maze[i].charAt(j);
			}
		}
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				if (i == 0 || j == 0 && !visited[i][j]) {
					recurse(i, j);
				}
			}
		}
		return result;
	}
	
	private int n, m;
	private char[][] maze;
	private boolean[][] visited;
	private int result;
	
	private void recurse(int i, int j) {
		if (visited[i][j]) return;
		
		visited[i][j] = true;
		if (i + 1 <= n) {
			if (maze[i + 1][j] == '#') {
				result++;
			} else {
				recurse(i + 1, j);
			}
		}
		if (i - 1 >= 1) {
			if (maze[i - 1][j] == '#') {
				result++;
			} else {
				recurse(i - 1, j);
			}
		}
		if (j + 1 <= m) {
			if (maze[i][j + 1] == '#') {
				result++;
			} else {
				recurse(i, j + 1);
			}
		}
		if (j - 1 >= 1) {
			if (maze[i][j - 1] == '#') {
				result++;
			} else {
				recurse(i, j - 1);
			}
		}
	}
}
