package codeforces.contests201_300.problemset208;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BloodCousins implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public BloodCousins() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    initTree();
    buildSparseTable();
    initDepths();
    queries();
  }

  private int n, q;
  private List<List<Integer>> tree;
  private int[][] parent;
  private int[] depth;
  private Map<Integer, List<Integer>> levels;
  private int[] indexOf;

  private void initTree() {
    n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i <= n; i++) {
      int parent = in.ni();
      if (parent != 0) {
        tree.get(parent).add(i);
      }
    }
  }

  private void buildSparseTable() {
    parent = new int[n + 1][18];
    for (int p = 1; p <= n; p++) {
      List<Integer> children = tree.get(p);
      for (int child : children) {
        parent[child][0] = p;
      }
    }
    for (int i = 1; i < 18; i++) {
      for (int node = 1; node <= n; node++) {
        parent[node][i] = parent[parent[node][i - 1]][i - 1];
      }
    }
  }

  private void initDepths() {
    depth = new int[n + 1];
    indexOf = new int[n + 1];
    levels = new HashMap<>();
    for (int node = 1; node <= n; node++) {
      if (parent[node][0] == 0) {
        dfs(node, 1);
      }
    }
  }

  private void dfs(int node, int d) {
    depth[node] = d;
    List<Integer> atTheSameLevel = levels.getOrDefault(d, new ArrayList<>());
    indexOf[node] = atTheSameLevel.size();
    atTheSameLevel.add(node);
    levels.put(d, atTheSameLevel);

    for (int child : tree.get(node)) {
      dfs(child, d + 1);
    }
  }

  private void queries() {
    q = in.ni();
    while (q-- > 0) {
      int node = in.ni(), level = in.ni();
      if (depth[node] <= level) {
        out.print(0);
      } else {
        int parent = findParent(node, level);
        List<Integer> atTheSameLevel = levels.get(depth[node]);
        int left = findLeft(atTheSameLevel, parent, node);
        int right = findRight(atTheSameLevel, parent, node);
        out.print(right - left);
      }
      out.print(' ');
    }
  }

  private int findParent(int node, int level) {
    int result = node;
    while (level > 0) {
      for (int i = 0; i < 18; i++) {
        int bit = 1 << i;
        if ((level & bit) != 0) {
          result = parent[result][i];
          level -= bit;
        }
      }
    }
    return result;
  }

  //which is the leftmost index, such that lca(node, idx) == parent or depth[lca(node, index)] < parent
  private int findLeft(List<Integer> list, int parent, int node) {
    int left = 0, right = indexOf[node] - 1, result = right + 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int lca = lca(list.get(mid), node);
      if (lca == parent) {
        result = min(result, mid);
        right = mid - 1;
      } else if (depth[lca] > depth[parent]) {
        result = min(result, mid);
        right = mid - 1;
      } else if (depth[lca] <= depth[parent]) {
        left = mid + 1;
      }
    }
    return result;
  }

  //which is the rightmost index, such that lca(node, idx) == parent or depth[lca(node, index)] < parent
  private int findRight(List<Integer> list, int parent, int node) {
    int left = indexOf[node] + 1, right = list.size() - 1, result = left - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int lca = lca(list.get(mid), node);
      if (lca == parent) {
        result = max(result, mid);
        left = mid + 1;
      } else if (depth[lca] > depth[parent]) {
        result = max(result, mid);
        left = mid + 1;
      } else if (depth[lca] <= depth[parent]) {
        right = mid - 1;
      }
    }
    return result;
  }

  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      v = u ^ v ^ (u = v);
    }
    for (int i = 17; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        u = parent[u][i];
      }
    }
    if (u == v) {
      return u;
    }
    for (int i = 17; i >= 0; i--) {
      if (parent[u][i] != -1 && parent[u][i] != parent[v][i]) {
        u = parent[u][i];
        v = parent[v][i];
      }
    }
    return parent[u][0];

  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (BloodCousins instance = new BloodCousins()) {
      instance.solve();
    }
  }
}
