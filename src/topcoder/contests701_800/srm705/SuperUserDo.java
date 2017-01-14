package topcoder.contests701_800.srm705;

public class SuperUserDo {
	
	public int install(int[] a, int[] b) {
		boolean[] x = new boolean[1001];
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = a[i]; j <= b[i] ; j++) {
				if (!x[j]) {
					x[j] = true;
					count++;
				}
			}
		}
		return count;
	}
	
}
