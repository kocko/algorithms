package topcoder.contests501_600.srm596;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class FoxAndSightseeing {
	
	public int getMin(int[] position) {
		int n = position.length;
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i++) {
			int prev = 0;
			int total = 0;
			for (int j = 1; j < n; j++) {
				if (i != j) {
					total += abs(position[j] - position[prev]);
					prev = j; 
				}
			}
			result = min(result, total);
		}
		return result;
	}
	
}
