package topcoder.contests701_800.srm717;

import java.util.Arrays;

public class LexmaxReplace {
	
	public String get(String s, String t) {
		char[] result = s.toCharArray();
		char[] letters = t.toCharArray();
		int n = result.length, m = letters.length;
		Arrays.sort(letters);
		int idx = 0;
		for (int i = 0; i < n && idx < m; i++) {
			if (letters[m - idx - 1] > result[i]) {
				result[i] = letters[m - idx - 1];
				idx++;
			}
		}
		return new String(result);
	}
}
