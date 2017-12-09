package topcoder.contests701_800.srm725;

import static java.lang.Math.min;

public class FiveRooksDiv2 {
	
	public int findMax(String[] board) {
		int[] row = new int[8], col = new int[8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i].charAt(j) == 'R') {
				    row[i]++;
				    col[j]++;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 8; i++) {
			result = min(row[i], result);
			result = min(col[i], result);
		}
		return result;
	}
	
}
