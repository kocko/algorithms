package topcoder.contests401_500.srm407;

public class CorporationSalary {
	
	public long totalSalary(String[] x) {
		this.g = x;
		int n = x.length;
		salary = new long[n];
		for (int i = 0; i < n; i++) {
			salary[i] = -1L;
		}
		long result = 0L;
		for (int i = 0; i < n; i++) {
			result += dfs(i);
		}
		return result;
	}
	
	private String[] g;
	private long[] salary;
	
	private long dfs(int x) {
		if (salary[x] != -1) return salary[x];
		
		long result = 0L;
		int subs = 0;
		for (int i = 0; i < g[x].length(); i++) {
			if (g[x].charAt(i) == 'Y') {
				subs++;
				result += dfs(i);
			}
		}
		if (subs == 0) result = 1L;
		salary[x] = result;
		return result;
	}
	
}
