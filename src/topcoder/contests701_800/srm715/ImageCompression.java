package topcoder.contests701_800.srm715;

public class ImageCompression {
	
	public String isPossible(String[] image, int k) {
		int n = image.length, m = image[0].length();
		char[][] x = new char[n][m];
		for (int i = 0; i < n; i++) {
			x[i] = image[i].toCharArray();
		}
		boolean ok = true;
		for (int i = 0; i <= n - k; i += k) {
			for (int j = 0; j <= m - k; j += k) {
				for (int l = 0; l < k; l++) {
					for (int o = 0; o < k; o++) {
						if (x[i + o][j + l] != x[i][j]) ok = false;
					}
				}
			}
		}
		return ok ? "Possible" : "Impossible";
	}
}
