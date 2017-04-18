package topcoder.contests701_800.srm712;

public class RepeatNumberCompare {
	
	public String compare(int x1, int k1, int x2, int k2) {
		int m = String.valueOf(x1).length(), n = String.valueOf(x2).length();
		int x = m * k1, y = n * k2;
		if (x > y) return "Greater";
		else if (x < y) return "Less";
		else {
			StringBuilder a = new StringBuilder();
			for (int i = 0; i < k1; i++) {
				a.append(x1);
			}
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < k2; i++) {
				b.append(x2);
			}
			int size = a.length();
			for (int i = 0; i < size; i++) {
				if (a.charAt(i) > b.charAt(i)) return "Greater";
				else if (a.charAt(i) < b.charAt(i)) return "Less";
			}
			return "Equal";
		}
	}
}
