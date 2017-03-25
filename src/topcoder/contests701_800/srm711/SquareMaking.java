package topcoder.contests701_800.srm711;

import java.util.Arrays;

import static java.lang.Math.abs;

public class SquareMaking {
	
	public int getMinimalPrice(int a, int b, int c, int d) {
		int[] x = new int[] { a, b, c, d };
		Arrays.sort(x);
		int median = (x[1] + x[2]) / 2;
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += abs(x[i] - median);
		}
		return result;
	}
	
}
