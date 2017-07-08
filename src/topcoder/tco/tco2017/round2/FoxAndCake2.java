package topcoder.tco.tco2017.round2;

public class FoxAndCake2 {
	
	public String isPossible(int c, int s) {
		if (c > s) {
			int t = c;
			c = s;
			s = t;
		}
		return solve(c, s) ? "Possible" : "Impossible";
	}
	
	private boolean solve(int a, int b) {
		if (a % 2 == 0 && b % 2 == 0 || a % 3 == 0 && b % 3 == 0) return true;
		if (a == 5) {
			return b != 6;
		}
		return a >= 7;
	}
	
}
