package topcoder.contests300_400.srm354;

public class UnsealTheSafe {
	
	public long countPasswords(int n) {
		dp = new long[n][10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {                 
			    dp[i][j] = -1L;
			}
		}
		long result = 0L;
		for (int i = 0; i <= 9; i++) {
			result += recurse(n - 1, i);
		}
		return result;
	}
	
	private long[][] dp;
	
	private long recurse(int idx, int last) {
		if (idx == 0) return 1;
		
		if (dp[idx][last] != -1L) return dp[idx][last];
		
		long ans = 0L;
		for (int v : next(last)) {
			ans += recurse(idx - 1, v);	
		}
		return dp[idx][last] = ans;
	}
	
	private int[] next(int x) {
		switch (x){
			case 0: return new int[] {7};
			case 1: return new int[] {2, 4};
			case 2: return new int[] {1, 3, 5};
			case 3: return new int[] {2, 6};
			case 4: return new int[] {1, 5, 7};
			case 5: return new int[] {2, 4, 6, 8};
			case 6: return new int[] {3, 5, 9};
			case 7: return new int[] {0, 4, 8};
			case 8: return new int[] {5, 7, 9};
			case 9: return new int[] {6, 8};
		}
		return new int[]{};
	}
}
