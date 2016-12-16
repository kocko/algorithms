package topcoder.contests701_800.srm703;

import java.util.Arrays;

public class GCDGraph {
	
	private class DisjointSet {
		private int[] root;
		private int[] size;
		
		private DisjointSet(int n) {
			root = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				root[i] = i;
			}
			size = new int[n + 1];
			Arrays.fill(size, 1);
		}
		
		private int root(int x) {
			return x == root[x] ? x : (root[x] = root(root[x]));
		}
		
		private void union(int a, int b) {
			int x = root(a), y = root(b);
			if (x != y) {
				if (size[x] < size[y]) {
					int t = x;
					x = y;
					y = t;
				}
				root[y] = x;
				size[x] += size[y];
			}
		}
		
	}
	
	public String possible(int n, int k, int x, int y) {
		DisjointSet dsu = new DisjointSet(n);
		for (int i = k + 1; i <= n; i++) {
			if (dsu.root(i) == i) {
				for (int j = i; j <= n; j += i) {
					dsu.union(i, j);
				}
			}
		}
		return dsu.root(x) == dsu.root(y) ? "Possible" : "Impossible";
	}
}
