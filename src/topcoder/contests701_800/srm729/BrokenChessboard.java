package topcoder.contests701_800.srm729;

import static java.lang.Math.min;

public class BrokenChessboard {
	
	public int minimumFixes(String[] board) {
		int n = board.length, m = board[0].length();
		char[][] x = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				x[i][j] = board[i].charAt(j);
			}
		}
		char[][] a = new char[n][m], b = new char[n][m];
		fill(a, 'B', 'W');
		fill(b, 'W', 'B');
		int p = 0, q = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (x[i][j] != a[i][j]) p++;
				if (x[i][j] != b[i][j]) q++;
			}
		}
		return min(p, q);
	}
	
	private void fill(char[][] x, char even, char odd) {
		int n = x.length, m = x[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i + j) % 2 == 0) {
					x[i][j] = even;
				} else {
					x[i][j] = odd;
				}
			}
		}
	}
}
