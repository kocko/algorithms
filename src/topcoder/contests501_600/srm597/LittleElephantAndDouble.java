package topcoder.contests501_600.srm597;

import java.util.Arrays;

public class LittleElephantAndDouble {
	
	public String getAnswer(int[] a) {
		Arrays.sort(a);
		int n = a.length;
		int max = a[n - 1];
		for (int i = 0; i < n - 1; i++) {
			while (a[i] < max) {
				a[i] <<= 1;
			}
			if (a[i] > max) {
				return "NO";
			}
		}
		return "YES";
	}
	
}
