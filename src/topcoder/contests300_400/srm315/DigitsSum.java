package topcoder.contests300_400.srm315;

public class DigitsSum {
	
	public int lastDigit(int n) {
		String x = n + "";
		while (x.length() > 1) {
			x = sum(x);
		}
		return Integer.parseInt(x);
	}
	
	private String sum(String x) {
		int result = 0;
		for (char c : x.toCharArray()) {
			result += (c - '0');
		}
		return String.valueOf(result);
	}
}
