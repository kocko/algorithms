package topcoder.contests701_800.srm711;

public class StringTransform {
	
	public String isPossible(String s, String t) {
		char[] x = s.toCharArray(), y = t.toCharArray();
		int n = x.length;
		boolean[] have = new boolean[26];
		for (int i = 0; i < n; i++) {
			have[x[i] - 'a'] = true;
			if (!have[y[i] - 'a']) {
				return "Impossible";
			}
		}
		return "Possible";
	}
	
}
