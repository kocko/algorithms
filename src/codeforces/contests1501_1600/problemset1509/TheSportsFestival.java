package codeforces.contests1501_1600.problemset1509;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TheSportsFestival implements Closeable {

  private final InputReader in = new InputReader(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    x = new long[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nl();
    }
    if (n == 1) {
      out.println(0);
      return;
    }
    Arrays.sort(x);
    dp = new Long[n + 1][n + 1];
    long ans = (long) 1e15;
    for (int i = 1; i < n; i++) {
      ans = Math.min(ans, recurse(i, i));
    }
    out.println(ans);
  }

  private int n;
  private long[] x;
  private Long[][] dp;

  private long recurse(int left, int right) {
    if (left == 0 && right == n - 1) return 0;

    if (dp[left][right] != null) return dp[left][right];

    long cost = (long) 1e15;
    if (left > 0) {
      cost = Math.min(cost, x[right] - x[left - 1] + recurse(left - 1, right));
    }
    if (right < n - 1) {
      cost = Math.min(cost, x[right + 1] - x[left] + recurse(left, right + 1));
    }

    return dp[left][right] = cost;
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
    try (TheSportsFestival instance = new TheSportsFestival()) {
      instance.solve();
    }
  }
}
