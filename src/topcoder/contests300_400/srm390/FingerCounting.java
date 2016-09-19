package topcoder.contests300_400.srm390;

public class FingerCounting {
	
	public int maxNumber(int weakFinger, int maxCount) {
		int result = 0;
		int a = 1, current = 1;
		while (true) {
			if (current == weakFinger && maxCount == 0) break;
			if (current == weakFinger) {
				maxCount--;
			}
			current += a;
			result++;
			if (current == 1) a = -a;
			if (current == 5) a = -a;
		}
		return result;
	}
}
