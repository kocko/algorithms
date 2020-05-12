package codeforces.contests1301_1400.problemset1350;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OracAndModels implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      x = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        x[i] = in.ni();
      }
      dp = new Integer[n + 1];
      int max = 0;
      for (int i = n; i >= 1; i--) {
        max = Math.max(recurse(i), max);
      }
      out.println(max);
    }
  }

  private int[] x;
  private Integer[] dp;

  private int recurse(int idx) {
    if (idx == 1) return 1;

    if (dp[idx] != null) return dp[idx];

    int ans = 1, best = 0;
    for (int d = 1; d * d <= idx; d++) {
      if (idx % d == 0) {
        if (x[idx / d] < x[idx]) {
          best = Math.max(best, recurse(idx / d));
        }
        if (x[d] < x[idx]) {
          best = Math.max(best, recurse(d));
        }
      }
    }
    return dp[idx] = ans + best;
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
    try (OracAndModels instance = new OracAndModels()) {
      instance.solve();
    }
  }
}
