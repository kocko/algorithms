package topcoder.contests300_400.srm319;

import java.util.Scanner;

public class SkewSymmetric {
	
	public int minChanges(String[] a) {
		int n = a.length;
		int k = a[0].split("\\s").length;
		int[][] x = new int[n][k];
		int c = 0;
		for (String s : a) {
			int r = 0;
			Scanner sc = new Scanner(s);
			while (sc.hasNextInt()) {
				x[r][c] = sc.nextInt();
				r++;
			}
			c++;
		}
		n = x.length;
		int m = x[0].length, result = 0; 
		for (int i = 0; i < n; i++) {
			for (int j = i; j < m; j++) {
				if (i == j && x[i][j] != 0) {
					x[i][j] = 0;
					result++;
				} else {
					if (x[i][j] != -x[j][i]) {
						x[i][j] = -x[j][i];
						result++;
					}
				}
			}
		}
		return result;
	}
	
}
