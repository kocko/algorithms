package codeforces.contests301_400.problemset321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CielTheCommander implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    sub = new int[n + 1];
    used = new boolean[n + 1];
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    rank = new char[n + 1];
    decompose(1, 0, 0);
    for (int i = 1; i <= n; i++) {
      out.print(rank[i]);
      out.print(' ');
    }
  }

  private List<List<Integer>> tree = new ArrayList<>();
  private int[] sub;
  private char[] rank;
  private boolean[] used;

  private void decompose(int u, int p, int r) {
    int n = dfs(u, p);
    int centroid = centroid(u, p, n);
    rank[centroid] = (char) ('A' + r);
    used[centroid] = true;
    for (int v : tree.get(centroid)) {
      if (!used[v]) {
        decompose(v, centroid, r + 1);
      }
    }
    tree.get(centroid).clear();
  }

  private int dfs(int u, int parent) {
    sub[u] = 1;
    for (int v : tree.get(u))
      if (v != parent && !used[v]) {
        sub[u] += dfs(v, u);
      }
    return sub[u];
  }

  private int centroid(int u, int parent, int n) {
    for (int v : tree.get(u)) {
      if (!used[v] && v != parent && sub[v] > n / 2) {
        return centroid(v, u, n);
      }
    }
    return u;
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
    try (CielTheCommander instance = new CielTheCommander()) {
      instance.solve();
    }
  }
}
