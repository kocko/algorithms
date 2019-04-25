package topcoder.contests701_800.srm756;

public class PAndPuns {
	
	public String check(String text) {
		char[] x = text.toCharArray();
		int n = text.length();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (x[i] == x[j] && x[i + 1] == x[j + 1] && !overlap(i, j)) return "pun";	
			}
		}
		return "not a pun";
	}
	
	private boolean overlap(int i, int j) {
		return i == j || i + 1 == j || i == j + 1;
	}
}
