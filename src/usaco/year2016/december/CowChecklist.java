package usaco.year2016.december;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CowChecklist implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CowChecklist() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("checklist.in"));
    out = new PrintWriter(new FileOutputStream("checklist.out"));
  }

  public void solve() {
    n = in.ni();
    m = in.ni();
    h = new int[n][2];
    g = new int[m][2];
    for (int i = 0; i < n; i++) {
      h[i][0] = in.ni();
      h[i][1] = in.ni();
    }
    for (int i = 0; i < m; i++) {
      g[i][0] = in.ni();
      g[i][1] = in.ni();
    }
    dp = new Long[n + 1][m + 1][2];
    out.println(recurse(1, 0, 0));
  }

  private int n, m;
  private int[][] h, g;

  private final int oo = (int) 1e16;
  private Long[][][] dp;

  private long recurse(int i, int j, int last) {
    if (j == m && i == n) return last == 0 ? 0 : oo;

    if (dp[i][j][last] != null) return dp[i][j][last];

    int[] john = last == 0 ? h[i - 1] : g[j - 1];
    long ans = oo;
    if (i < n) {
      int d = dist(john, h[i]);
      ans = Math.min(ans, d + recurse(i + 1, j, 0));
    }
    if (j < m) {
      int d = dist(john, g[j]);
      ans = Math.min(ans, d + recurse(i, j + 1, 1));
    }
    return dp[i][j][last] = ans;
  }

  private int dist(int[] x, int[] y) {
    return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
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
    try (CowChecklist instance = new CowChecklist()) {
      instance.solve();
    }
  }
}
