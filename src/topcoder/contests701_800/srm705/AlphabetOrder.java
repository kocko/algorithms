package topcoder.contests701_800.srm705;

public class AlphabetOrder {
	
	public String isOrdered(String[] words) {
		int[][] g = new int[26][26];
		int[] deg = new int[26];
		for (String x : words) {
			char[] c = x.toCharArray();
			for (int i = 0; i < c.length - 1; i++) {
				int u = c[i] - 'a', v = c[i + 1] - 'a';
				if (u != v) {
					g[c[i] - 'a'][c[i + 1] - 'a'] = 1;
					deg[c[i + 1] - 'a']++;
				}
			}
		}
		this.g = g;
		for (int i = 0; i < 26; i++) {
			if (deg[i] == 0) dfs(i);
		}
		for (int i = 0; i < 26; i++) {
			if (!visited[i]) cycle = true;
		}
		return cycle ? "Impossible" : "Possible";
	}
	
	private boolean[] visited = new boolean[26];
	private boolean[] stack = new boolean[26];
	private int[][] g;
	private boolean cycle;
	
	private void dfs(int x) {
		visited[x] = stack[x] = true;
		int[] next = g[x];
		for (int i = 0; i < next.length; i++) {
			if (next[i] == 1 && i != x && stack[i] && visited[i]) {
				cycle = true;
				return;
			}
			if (!visited[i] && next[i] == 1) {
				dfs(i);
			}
		}
		stack[x] = false;
	}
	
}
