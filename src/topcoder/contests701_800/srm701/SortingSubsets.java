package topcoder.contests701_800.srm701;

import java.util.Arrays;

public class SortingSubsets {

	public int getMinimalSize(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		System.arraycopy(a, 0, b, 0, n);
		Arrays.sort(b);
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) result++;
		}
		return result;
	}
	
}
