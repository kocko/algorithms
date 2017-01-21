package topcoder.contests701_800.srm706;

public class SellingFruits {
	
	public int maxDays(int x, int f, int d, int p) {
		if (f > (d / x)) return (d / x);
		else {
			int result = f;
			d -= f * x;
			result += (d / (p + x));
			return result;
		}
	}
	
}
