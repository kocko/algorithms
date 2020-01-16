package codeforces.contests1201_1300.problemset1288;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoArrays2 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    dp = new Long[2 * m][n + 1];
    out.println(recurse(0, 1));
  }

  private final long MOD = (long) 1e9 + 7;
  private int n, m;
  private Long[][] dp;

  private Long recurse(int idx, int last) {
    if (idx == 2 * m) return 1L;

    if (dp[idx][last] != null) return dp[idx][last];

    long ans = 0;
    for (int next = last; next <= n; next++) {
      ans += recurse(idx + 1, next);
      ans %= MOD;
    }
    return dp[idx][last] = ans;
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
    try (TwoArrays2 instance = new TwoArrays2()) {
      instance.solve();
    }
  }
}
