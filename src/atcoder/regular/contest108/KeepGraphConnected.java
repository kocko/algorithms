package atcoder.regular.contest108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class KeepGraphConnected implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        root[y] = x;
        size[x] += size[y];
        return true;
      }
      return false;
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    DisjointSet dsu = new DisjointSet(n + 1);
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    Set<Integer> unused = new HashSet<>();
    for (int c = 1; c <= n; c++) {
      unused.add(c);
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni(), w = in.ni();
      if (dsu.join(u, v)) {
        tree.get(u).add(new int[]{v, w});
        tree.get(v).add(new int[]{u, w});
        unused.remove(w);
      }
    }
    this.unused = new ArrayDeque<>();
    for (int value : unused) {
      this.unused.addLast(value);
    }
    if (dsu.size[dsu.root(1)] != n) {
      out.println(-1);
    } else {
      color = new int[n + 1];
      color[1] = 1;
      dfs(1, 0);
      for (int idx = 1; idx <= n; idx++) {
        out.println(color[idx]);
      }
    }
  }

  private ArrayDeque<Integer> unused;
  private List<List<int[]>> tree;
  private int[] color;

  private void dfs(int u, int p) {
    for (int[] v : tree.get(u)) if (v[0] != p) {
      if (v[1] != color[u]) {
        color[v[0]] = v[1];
      } else {
        color[v[0]] = unused.pollFirst();
      }
      dfs(v[0], u);
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
    try (KeepGraphConnected instance = new KeepGraphConnected()) {
      instance.solve();
    }
  }
}
