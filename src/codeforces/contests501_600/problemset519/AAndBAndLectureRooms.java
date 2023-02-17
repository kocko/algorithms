package codeforces.contests501_600.problemset519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AAndBAndLectureRooms implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public AAndBAndLectureRooms() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class LCA {
    private static final int MAX_LOG_N = 17;

    private int n;
    private int[] depth;
    private int[][] parent;

    private List<List<Integer>> tree;

    public LCA(List<List<Integer>> tree) {
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

    public int findKth(int u, int k) {
      for (int i = MAX_LOG_N; i >= 0; i--) {
        int bit = 1 << i;
        if (k >= bit) {
          u = parent[u][i];
          k -= bit;
        }
      }
      return u;
    }

  }

  public void solve() {
    read();
    calculateSizes();
    queries();
  }

  private int n;
  private List<List<Integer>> tree;

  public void read() {
    n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
  }

  private void calculateSizes() {
    size = new int[n + 1];
    size[0] = n;
    dfs(1, 0);
  }

  private int[] size;

  private int dfs(int node, int parent) {
    int result = 1;
    for (int next : tree.get(node))
      if (next != parent) {
        result += dfs(next, node);
      }
    return size[node] = result;
  }

  private void queries() {
    LCA lca = new LCA(tree);
    int q = in.ni();
    while (q-- > 0) {
      int u = in.ni(), v = in.ni();
      int lo = v;
      if (lca.depth[u] > lca.depth[v]) {
        lo = u;
      }
      int parent = lca.of(u, v);
      int distance;
      if (u == parent || v == parent) {
        distance = max(lca.depth[u], lca.depth[v]) - min(lca.depth[u], lca.depth[v]);
      } else {
        distance = lca.depth[u] + lca.depth[v] - 2 * lca.depth[parent];
      }
      int result;
      if (u == v) {
        result = n;
      } else if (lca.depth[u] == lca.depth[v]) {
        int la = lca.findKth(u, lca.depth[u] - lca.depth[parent] - 1);
        int lb = lca.findKth(v, lca.depth[v] - lca.depth[parent] - 1);
        result = n - size[la] - size[lb];
      } else if (distance % 2 == 1) {
        result = 0;
      } else {
        int mid = lca.findKth(lo, distance / 2);
        int lb = lca.findKth(lo, distance / 2 - 1);
        result = size[mid] - size[lb];
      }
      out.println(result);
    }
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
    try (AAndBAndLectureRooms instance = new AAndBAndLectureRooms()) {
      instance.solve();
    }
  }
}
