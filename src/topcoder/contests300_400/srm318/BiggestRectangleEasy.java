package topcoder.contests300_400.srm318;

public class BiggestRectangleEasy {
	
	public int findArea(int n) {
		if (n % 2 == 1) {
			n--;
		}
		n /= 2;
		if (n % 2 == 1) {
			return n / 2 * (n / 2 + 1);
		}
		return n * n / 4;
	}
}
