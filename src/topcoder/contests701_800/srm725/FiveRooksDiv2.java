package topcoder.contests701_800.srm725;

import static java.lang.Math.max;

public class FiveRooksDiv2 {
	
	public int findMax(String[] board) {
		int[] row = new int[8], col = new int[8];
		int result = 0;
		for (int i = 0; i < 8; i++) {
		    int ans = 0;
		    int bans = 0;
			for (int j = 0; j < 8; j++) {
				if (board[i].charAt(j) == 'R') {
				    ans++;
				}
                if (board[j].charAt(i) == 'R') {
                    bans++;
                }
			}
			result = max(ans, result);
			result = max(bans, result);
		}
		return result;
	}
}
