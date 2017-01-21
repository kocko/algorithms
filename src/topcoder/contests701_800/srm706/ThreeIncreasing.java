package topcoder.contests701_800.srm706;

public class ThreeIncreasing {
	
	public int minEaten(int a, int b, int c) {
		int result = 0;
		if (c <= b) {
			result += (b - c + 1);
			b -= (b - c + 1);
			if (b <= 0) return -1;
		}
		if (b <= a) {
			result += (a - b + 1);
			a -= (a - b + 1);
			if (a <= 0) return -1;
		}
		return result;
	}
}
