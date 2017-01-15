package topcoder.contests300_400.srm319;

public class BusSeating {
	
	public double getArrangement(String leftRow, String rightRow) {
		char[] left = leftRow.toCharArray();
		char[] right = rightRow.toCharArray();
		char[] temp = (leftRow + rightRow).toCharArray();
		double[][] dist = new double[20][20];
		for (int i = 0; i < 10; i++) {
			if (left[i] == '-') {
				for (int j = i + 1; j < 10; j++) {
					if (left[j] == '-') {
						dist[i][j] = dist[j][i] = j - i;
					}
				}
				for (int j = 0; j < 10; j++) {
					if (right[j] == '-') {
						dist[i][10 + j] = dist[10 + j][i] = Math.sqrt(4 + (j - i) * (j - i));
					}
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			if (right[i] == '-') {
				for (int j = i + 1; j < 10; j++) {
					if (right[j] == '-') {
						dist[10 + i][10 + j] = dist[10 + j][10 + i] = j - i;
					}
				}
			}
		}
		double min = 100000d;
		for (int i = 0; i < 20; i++) {
			for (int j = i + 1; j < 20; j++) {
				for (int k = j + 1; k < 20; k++) {
					if (temp[i] == '-' && temp[j] == '-' && temp[k] == '-') {
						double d = dist[i][j] + dist[j][k] + dist[i][k];
						if (d < min) {
							min = d;
						}
					}
 				}
			}
		}
		return min;
	}
	
}
