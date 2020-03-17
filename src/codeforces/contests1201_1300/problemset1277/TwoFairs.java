package codeforces.contests1201_1300.problemset1277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoFairs implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      graph = new ArrayList<>();
      n = in.ni();
      int m = in.ni(), x = in.ni(), y = in.ni();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        int u = in.ni(), v = in.ni();
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      out.println(solve(x, y));
    }
  }

  private long solve(int x, int y) {
    visited = new boolean[n + 1];
    visited[y] = true;
    dfs(x);
    long p = n - 1 - count;
    count = 0;

    visited = new boolean[n + 1];
    visited[x] = true;
    dfs(y);
    long q = n - 1 - count;
    count = 0;

    return p * q;
  }

  private List<List<Integer>> graph;
  private int n, count;
  private boolean[] visited;

  private void dfs(int u) {
    if (visited[u]) return;
    visited[u] = true;
    count++;
    for (int v : graph.get(u)) if (!visited[v]) dfs(v);
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
    try (TwoFairs instance = new TwoFairs()) {
      instance.solve();
    }
  }
}
