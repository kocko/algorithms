package topcoder.contests201_300.srm233;

import java.util.Arrays;

public class JustifyText {
	
	public String[] format(String[] text) {
		int n = text.length;
		String[] result = new String[n];
		int max = 0;
		for (String s : text) {
			max = Math.max(max, s.length());
		}
		for (int i = 0; i < n; i++) {
			result[i] = pad(text[i], max);
		}
		return result;
	}
	
	private String pad(String text, int size) {
		char[] result = new char[size];
		int n = text.length();
		Arrays.fill(result, ' ');
		for (int i = 0; i < text.length(); i++) {
			result[size - i - 1] = text.charAt(n - i - 1);
		}
		return new String(result);
	}
	
}
