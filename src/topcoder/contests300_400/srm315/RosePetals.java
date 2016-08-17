package topcoder.contests300_400.srm315;

public class RosePetals {
	
	public int getScore(int[] dice) {
		int result = 0;
		for (int i : dice) {
			if (i == 3 || i == 5) {
				result += (i - 1);
			}
		}
		return result;
	}
}
