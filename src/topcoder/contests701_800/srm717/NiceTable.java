package topcoder.contests701_800.srm717;

public class NiceTable {
	
	public String isNice(String[] t) {
		int n = t.length, m = t[0].length();
		int[][] table = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j] = t[i].charAt(j) - '0';
			}
		}
		boolean ok = false;
		int a = 1 << n, b = 1 << m;
		for (int i = 0; i < a; i++) {
			int[] x = new int[n];
			String binary = Integer.toBinaryString(i);
			for (int j = 0; j < binary.length(); j++) {
				x[n - j - 1] = binary.charAt(binary.length() - j - 1) - '0';
			}
			for (int j = 0; j < b; j++) {
				int[] y = new int[m];
				binary = Integer.toBinaryString(j);
				for (int k = 0; k < binary.length(); k++) {
					y[m - k - 1] = binary.charAt(binary.length() - k - 1) - '0';
				}
				ok |= verify(x, y, table);
			}
		}

		return ok ? "Nice" : "Not nice";
	}

	private boolean verify(int[] x, int[] y, int[][] table) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (table[i][j] != (x[i] ^ y[j])) return false;
			}
		}
		return true;
	}
}
