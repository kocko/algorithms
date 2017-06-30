package topcoder.contests701_800.srm716;

import java.util.Arrays;

public class Permutiple {

    public String isPossible(int x) {
		char[] copy = String.valueOf(x).toCharArray();
		Arrays.sort(copy);
		String d = new StringBuilder(new String(copy)).reverse().toString();
		int max = Integer.parseInt(d);
		for (int i = x + x; i <= max; i += x) {
			if (ok(i, x)) {
				return "Possible";
			}
		}
		return "Impossible";
	}
	
	private boolean ok(int x, int y) {
		String a = String.valueOf(x), b = String.valueOf(y);
		int[] m = new int[10], n = new int[10];
		for (char c : a.toCharArray()) m[c - '0']++;
		for (char c : b.toCharArray()) n[c - '0']++;
		for (int i = 0; i < 10; i++) {
			if (m[i] != n[i]) return false;
		}
		return true;
	}
}
