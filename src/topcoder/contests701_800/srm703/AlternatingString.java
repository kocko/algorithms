package topcoder.contests701_800.srm703;

public class AlternatingString {
	
	public int maxLength(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int result = 0;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (c[i] != c[i - 1]) {
				cnt++;
			} else {
				result = Math.max(result, cnt);
				cnt = 1;
			}
		}
		return Math.max(result, cnt);
	}
}
