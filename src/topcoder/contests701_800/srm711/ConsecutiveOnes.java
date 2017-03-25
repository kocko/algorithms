package topcoder.contests701_800.srm711;

import static java.lang.Math.min;

public class ConsecutiveOnes {
	
	public long get(long n, int k) {
		long result = Long.MAX_VALUE;
		long ones = (1L << k) - 1;
		while (ones < n) {
			for (int i = 0; i < 63; i++) {
				long bottom = (1L << i) - 1;
				long m = (1L << i);
				m |= n & ~bottom;
				m |= ones;
				if (m >= n) {
					result = min(result, m);
				}
			}
			ones <<= 1;
		}
		return min(result, ones);
	}
}
