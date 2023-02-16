package codeforces.contests1301_1400.problemset1328;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TreeQueries implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TreeQueries() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    init();
    dfs(1, -1, 1);
    sparseTable();
    queries();
  }

  private static final int LOG_MAX_N = 17;
  private int n, q;
  private List<List<Integer>> tree;
  private int[] depth;
  private int[][] parent;

  private void init() {
    n = in.ni();
    q = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    parent = new int[n + 1][LOG_MAX_N + 1];
    depth = new int[n + 1];
  }

  private void dfs(int node, int parent, int d) {
    depth[node] = d;
    for (int next : tree.get(node)) if (next != parent) {
      this.parent[next][0] = node;
      dfs(next, node, d + 1);
    }
  }

  private void sparseTable() {
    for (int level = 1; level <= LOG_MAX_N; level++) {
      for (int node = 1; node <= n; node++) {
        parent[node][level] = parent[parent[node][level - 1]][level - 1];
      }
    }
  }

  private void queries() {
    while (q-- > 0) {
      int m = in.ni();
      List<Integer> query = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        query.add(in.ni());
      }
      query.sort(Comparator.comparingInt(x -> -depth[x]));
      int idx = 0;
      int lastNode = query.get(0);
      boolean can = true;
      while (idx < m) {
        List<Integer> sameLevel = new ArrayList<>();
        sameLevel.add(query.get(idx++));
        while (idx < m && depth[query.get(idx)] == depth[sameLevel.get(0)]) {
          sameLevel.add(query.get(idx++));
        }
        int lca = lca(lastNode, sameLevel.get(0));
        for (int i = 1; i < sameLevel.size(); i++) {
          lca = lca(lca, sameLevel.get(i));
        }
        if (lca == sameLevel.get(0)) {
          lca = parent[lca][0];
        }
        if (depth[lca] != depth[sameLevel.get(0)] - 1) {
          can = false;
          break;
        }
      }
      out.println(can ? "YES" : "NO");
    }
  }

  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      v = u ^ v ^ (u = v);
    }
    for (int i = LOG_MAX_N; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        u = parent[u][i];
      }
    }
    if (u == v) {
      return u;
    }
    for (int i = LOG_MAX_N; i >= 0; i--) {
      if (parent[u][i] != 0 && parent[u][i] != parent[v][i]) {
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
    try (TreeQueries instance = new TreeQueries()) {
      instance.solve();
    }
  }
}
