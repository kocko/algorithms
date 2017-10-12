package topcoder.contests701_800.srm722;

public class HillClimber {
	
	public int longest(int[] height) {
		int max = 0, current = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] > height[i - 1]) current++;
			else {
				max = Math.max(current, max);
				current = 0;
			}
		}
		return Math.max(current, max);
	}
}
