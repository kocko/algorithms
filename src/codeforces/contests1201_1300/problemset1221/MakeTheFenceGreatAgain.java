package codeforces.contests1201_1300.problemset1221;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.min;

public class MakeTheFenceGreatAgain implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      n = in.ni();
      a = new long[n];
      cost = new long[n];
      dp = new long[n][3];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
        cost[i] = in.ni();
        for (int j = 0; j < 3; j++) {
          dp[i][j] = -1L;
        }
      }
      long ans = Long.MAX_VALUE;
      for (int i = 0; i < 3; i++) {
        ans = min(ans, i * cost[0] + recurse(1, i));
      }
      out.println(ans);
    }
  }

  private int n;
  private long[] a, cost;
  private long[][] dp;

  private long recurse(int idx, int prev) {
    if (idx == n) return 0;

    if (dp[idx][prev] != -1) return dp[idx][prev];

    long h = a[idx - 1] + prev;
    long ans = Long.MAX_VALUE;
    for (int increase = 0; increase < 3; increase++) {
      if (a[idx] + increase != h) {
        ans = min(ans, increase * cost[idx] + recurse(idx + 1, increase));
      }
    }

    return dp[idx][prev] = ans;
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
    try (MakeTheFenceGreatAgain instance = new MakeTheFenceGreatAgain()) {
      instance.solve();
    }
  }
}
