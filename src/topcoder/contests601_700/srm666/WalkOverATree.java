package topcoder.contests601_700.srm666;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class WalkOverATree {

  public int maxNodesVisited(int[] parent, int L) {
    n = parent.length + 1;
    if (n == 1) return 1;
    level = new int[n];
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      tree.get(parent[i]).add(i + 1);
      tree.get(i + 1).add(parent[i]);
    }
    bfs();
    dp = new Integer[n][L + 1];
    return min(recurse(0, L), n);
  }

  private int n;
  private List<List<Integer>> tree = new ArrayList<>();
  private int[] level;
  private Integer[][] dp;

  private void bfs() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    visited[0] = true;
    queue.addLast(0);
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : tree.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.offerLast(v);
          level[v] = level[u] + 1;
        }
      }
    }
  }

  private Integer recurse(int u, int stepsLeft) {
    if (stepsLeft == 0) return 1;
    
    if (dp[u][stepsLeft] != null) return dp[u][stepsLeft];
    
    int ans = 0;
    for (int v : tree.get(u)) {
      if (level[v] > level[u]) {
        ans = max(ans, 1 + recurse(v, stepsLeft - 1));
      } else {
        ans = max(ans, recurse(v, stepsLeft - 1));
      }
    }
    return dp[u][stepsLeft] = ans;
  }
}
