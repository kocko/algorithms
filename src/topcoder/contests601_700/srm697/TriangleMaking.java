package topcoder.contests601_700.srm697;

import java.util.Arrays;

public class TriangleMaking {
	
	public int maxPerimeter(int a, int b, int c) {
		int[] x = {a, b, c};
		Arrays.sort(x);
		while (true) {
			if (x[0] + x[1] > x[2] && x[1] + x[2] > x[0] && x[2] + x[0] > x[1]) break;
			x[2]--;
			Arrays.sort(x);
		}
		return x[0] + x[1] + x[2];
	}
	
}
