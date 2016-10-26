package topcoder.contests701_800;

public class SquareFreeString {

	public String isSquareFree(String s) {
		int n = s.length();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				String sub = s.substring(i, j + 1);
				if (isSquare(sub)) {
					return "not square-free";
				}
			}
		}
		return "square-free";
	}

	private boolean isSquare(String s) {
		if (s.length() % 2 == 0) {
			int n = s.length();
			for (int i = 0; i < n / 2; i++) {
				if (s.charAt(i) != s.charAt(n / 2 + i)) return false;
			}
			return true;
		}
		return false;
	}
}