package atcoder.beginner.contest188;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Peddler implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    a = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nl();
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      graph.get(u).add(v);
    }
    dp = new Long[n + 1];
    for (int i = 1; i <= n; i++) {
      if (graph.get(i).size() > 0) {
        recurse(i);
      }
    }
    long result = -oo;
    for (int i = 1; i <= n; i++) {
      if (graph.get(i).size() > 0) {
        for (int v : graph.get(i)) {
          result = Math.max(result, dp[v] - a[i]);
        }
      }
    }
    out.println(result);
  }

  private long[] a;
  private List<List<Integer>> graph = new ArrayList<>();

  private final int oo = (int) 1e10;
  private Long[] dp;

  private long recurse(int u) {
    if (dp[u] != null) return dp[u];

    long maxSellingPrice = -oo;
    for (int v : graph.get(u)) {
      maxSellingPrice = Math.max(maxSellingPrice, recurse(v));
    }
    return dp[u] = Math.max(maxSellingPrice, a[u]);
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
    try (Peddler instance = new Peddler()) {
      instance.solve();
    }
  }
}
