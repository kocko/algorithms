package codeforces.contests201_300.problemset231;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Cactus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    int m = in.ni();
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    compress();
    init();
    calculatePowers();
    int q = in.ni();
    while (q-- > 0) {
      int u = cycle[in.ni()], v = cycle[in.ni()];
      int lca = lca(u, v);
      int count = c[u] + c[v] - 2 * c[lca] + color[lca];
      out.println(powers[count]);
    }
  }

  private int n, cycleId;
  private int[] next, depth, cycle, color;
  private long[] powers;
  private List<List<Integer>> graph = new ArrayList<>();
  private List<List<Integer>> tree = new ArrayList<>();

  private void compress() {
    depth = new int[n + 1];
    next = new int[n + 1];
    cycle = new int[n + 1];
    color = new int[n + 1];
    dfs(1, 0);
    for (int i = 1; i <= n; i++) {
      if (cycle[i] == 0) {
        cycle[i] = ++cycleId;
      }
    }
    buildTree();
  }

  private void dfs(int u, int parent) {
    depth[u] = depth[parent] + 1;
    for (int v : graph.get(u))
      if (v != parent) {
        if (depth[v] == 0) {
          next[u] = v;
          dfs(v, u);
        } else {
          if (cycle[v] == 0) {
            cycleId++;
            int vertex = v;
            cycle[u] = cycleId;
            while (vertex != u) {
              cycle[vertex] = cycleId;
              vertex = next[vertex];
            }
            color[cycleId] = 1;
          }
        }
      }
  }

  private void buildTree() {
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.addLast(1);
    boolean[] visited = new boolean[n + 1];
    visited[1] = true;
    while (queue.size() > 0) {
      int u = queue.pollFirst();
      for (int v : graph.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.addLast(v);
          if (cycle[u] != cycle[v]) {
            tree.get(cycle[u]).add(cycle[v]);
            tree.get(cycle[v]).add(cycle[u]);
          }
        }
      }
    }
  }

  private void calculatePowers() {
    final long MOD = 1000000007L;
    powers = new long[n + 1];
    powers[0] = 1;
    for (int i = 1; i <= n; i++) {
      powers[i] = powers[i - 1] << 1;
      powers[i] %= MOD;
    }
  }

  private void init() {
    pa = new int[n + 1][18];
    c = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < 18; j++) {
        pa[i][j] = -1;
      }
    }
    dfs2(1, 0, 0, 0);
    for (int i = 1; i <= 17; i++) {
      for (int v = 1; v <= n; v++) {
        if (pa[v][i - 1] != -1) {
          int parent = pa[v][i - 1];
          pa[v][i] = pa[parent][i - 1];
        }
      }
    }
  }

  private int[][] pa;
  private int[] c;

  private void dfs2(int u, int p, int d, int cycles) {
    pa[u][0] = p;
    depth[u] = d;
    c[u] = cycles + color[u];
    for (int v : tree.get(u)) {
      if (v != p) {
        dfs2(v, u, d + 1, c[u]);
      }
    }
  }

  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      v = u ^ v ^ (u = v);
    }
    for (int i = 17; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        u = pa[u][i];
      }
    }
    if (u == v) {
      return u;
    }
    for (int i = 17; i >= 0; i--) {
      if (pa[u][i] != -1 && pa[u][i] != pa[v][i]) {
        u = pa[u][i];
        v = pa[v][i];
      }
    }
    return pa[u][0];
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
    try (Cactus instance = new Cactus()) {
      instance.solve();
    }
  }
}
