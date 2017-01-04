package topcoder.contests701_800.srm704;

import java.util.Arrays;

public class SwapAndArithmetic {
	
	public String able(int[] x) {
		int n = x.length;
		Arrays.sort(x);
		int d = x[1] - x[0];
		for (int i = 2; i < n; i++) {
			if (x[i] - x[i - 1] != d) {
				return "Impossible";
			}
		}
		return "Possible";
	}
	
}
