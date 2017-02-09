package topcoder.contests701_800.srm708;

public class SafeBetting {
	
	public int minRounds(int a, int b, int c) {
		int result = 0;
		while (b < c) {
			int max = b - a;
			b += max;
			result++;
		}
		return result;
	}
}
