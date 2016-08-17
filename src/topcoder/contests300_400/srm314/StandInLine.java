package topcoder.contests300_400.srm314;

public class StandInLine {
	
	public int[] reconstruct(int[] left) {
		int n = left.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int k = -1;
			for (int j = 0; j <= left[i]; j++) {
				do {
					k++;
 				} while (result[k] > 0);
			}
			result[k] = i + 1;
		}
		return result;
	}
	
}
