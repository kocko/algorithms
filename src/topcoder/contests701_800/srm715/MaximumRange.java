package topcoder.contests701_800.srm715;

public class MaximumRange {
	
	public int findMax(String s) {
		int p = 0, m = 0;
		for (char c : s.toCharArray()) {
			if (c == '+') p++;
			else m++;
		}
		return Math.max(p, m);
	}
}
