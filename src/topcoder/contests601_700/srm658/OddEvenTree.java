package topcoder.contests601_700.srm658;

import java.util.ArrayDeque;

public class OddEvenTree {
  
  public int[] getTree(String[] x) {
    int n = x.length, idx = 0;
    int[] result = new int[2 * n - 2];
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    visited[0] = true;
    int[] level = new int[n];
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v = 0; v < n; v++) {
        if (!visited[v] && x[u].charAt(v) == 'O') {
          result[idx++] = u;
          result[idx++] = v;
          queue.add(v);
          level[v] = level[u] ^ 1;
          visited[v] = true;
        }
      }
    }
    boolean valid = idx == result.length;
    for (int u = 0; u < n; u++) {
      for (int v = 0; v < n; v++) {
        if (u == v) {
          valid &= x[u].charAt(u) == 'E';
        } else {
          valid &= x[u].charAt(v) == x[v].charAt(u);
          int dist = x[u].charAt(v) == 'E' ? 0 : 1;
          valid &= (level[u] ^ level[v]) == dist;
        }
      }
    }
    if (!valid) return new int[]{-1};
    return result;
  }

}
