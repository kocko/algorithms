package topcoder.contests701_800.srm709;

public class Permatchd2 {
	
	private class DisjointSet {
		private int[] root;
		private int[] size;
		private int[] count;
		
		private DisjointSet(int n) {
			root = new int[n];
			size = new int[n];
			count = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
				size[i] = 1;
				count[i] = 0;
			}
		}
		
		private int root(int x) {
			return (x == root[x]) ? x : (root[x] = root(root[x]));
		}
		
		private void join(int a, int b) {
			int x = root(a), y = root(b);
			if (x != y) {
				if (size[x] < size[y]) {
					y = (x ^ y) ^ (x = y);
				}
				root[y] = x;
				size[x] += size[y];
				count[x] += count[y];
			}
			count[x]++;
		}
		
	}
	
	public int fix(String[] graph) {
		int n = graph.length;
		DisjointSet dsu = new DisjointSet(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (graph[i].charAt(j) == 'Y') {
					dsu.join(i, j);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (dsu.root(i) == i && dsu.count[i] % 2 == 1) {
				boolean found = false;
				for (int j = 0; j < n; j++) {
					if (i != j && dsu.root(j) == j && dsu.count[j] % 2 == 0) {
						dsu.join(i, j);
						result++;
						found = true;
						break;
					}
				}
				if (!found) {
					int size = dsu.size[i];
					if (dsu.count[i] < (size * (size - 1)) / 2) {
						dsu.count[i]++;
						result++;
					} else {
						for (int j = 0; j < n; j++) {
							if (i != j && dsu.root(j) == j && dsu.count[j] % 2 == 1) {
								dsu.join(i, j);
								result++;
								break;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (dsu.root(i) == i && dsu.count[i] % 2 == 1) {
				int size = dsu.size[i];
				if (dsu.count[i] < (size * (size - 1)) / 2) {
					dsu.count[i]++;
					result++;
				} else return -1;
			}
		}
		return result;
	}
}
