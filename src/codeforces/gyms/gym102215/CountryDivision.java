package codeforces.gyms.gym102215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CountryDivision implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    depth = new int[n + 1];
    pa = new int[n + 1][18];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= 17; j++) {
        pa[i][j] = -1;
      }
    }
    dfs(1, -1, 0);

    for (int i = 1; i <= 17; i++) {
      for (int j = 1; j <= n; j++) {
        if (pa[j][i - 1] != -1) {
          pa[j][i] = pa[pa[j][i - 1]][i - 1];
        }
      }
    }

    int q = in.ni();
    while (q-- > 0) {
      int r = in.ni(), b = in.ni();
      int[] red = new int[r + 1], blue = new int[b + 1];
      for (int i = 1; i <= r; i++) {
        red[i] = in.ni();
        if (i > 1) {
          red[0] = lca(red[0], red[i]);
        } else {
          red[0] = red[1];
        }
      }
      for (int i = 1; i <= b; i++) {
        blue[i] = in.ni();
        if (i > 1) {
          blue[0] = lca(blue[0], blue[i]);
        } else {
          blue[0] = blue[1];
        }
      }
      boolean ok = red[0] != blue[0];
      if (depth[red[0]] <= depth[blue[0]]) {
        for (int i = 1; i <= r; i++) {
          ok &= lca(red[i], blue[0]) != blue[0];
        }
      } else {
        for (int i = 1; i <= b; i++) {
          ok &= lca(blue[i], red[0]) != red[0];
        }
      }
      out.println(ok ? "YES" : "NO");
    }
  }

  private List<List<Integer>> graph = new ArrayList<>();
  private int[] depth;
  private int[][] pa;

  private void dfs(int u, int p, int d) {
    pa[u][0] = p;
    depth[u] = d;

    for (int next : graph.get(u)) {
      if (next != p) {
        dfs(next, u, d + 1);
      }
    }
  }

  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      int t = u;
      u = v;
      v = t;
    }
    for (int i = 17; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        u = pa[u][i];
      }
    }
    if (u == v) return u;
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
    try (CountryDivision instance = new CountryDivision()) {
      instance.solve();
    }
  }
}
