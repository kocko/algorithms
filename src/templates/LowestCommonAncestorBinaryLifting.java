package templates;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestorBinaryLifting {

  private static final int MAX_LOG_N = 17; //change this with accordance to the size of your tree

  private int n;
  private int[] depth;
  private int[][] parent;

  private List<List<Integer>> tree;

  public LowestCommonAncestorBinaryLifting(List<List<Integer>> tree) {
    this.tree = tree;
    this.n = tree.size();
    parent = new int[n + 1][MAX_LOG_N + 1];
    depth = new int[n + 1];
    dfs(1, -1, 1);
    sparseTable();
  }

  private void dfs(int node, int previous, int d) {
    depth[node] = d;
    for (int next : tree.get(node)) {
      if (next != previous) {
        parent[next][0] = node;
        dfs(next, node, d + 1);
      }
    }
  }

  private void sparseTable() {
    for (int level = 1; level <= MAX_LOG_N; level++) {
      for (int node = 1; node <= n; node++) {
        parent[node][level] = parent[parent[node][level - 1]][level - 1];
      }
    }
  }

  public int of(int u, int v) {
    if (depth[u] < depth[v]) {
      v = u ^ v ^ (u = v);
    }
    for (int i = MAX_LOG_N; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        u = parent[u][i];
      }
    }
    if (u == v) {
      return u;
    }
    for (int i = MAX_LOG_N; i >= 0; i--) {
      if (parent[u][i] != 0 && parent[u][i] != parent[v][i]) {
        u = parent[u][i];
        v = parent[v][i];
      }
    }
    return parent[u][0];
  }

}
