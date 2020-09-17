package timus.volume03;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheDebutAlbum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    a = in.ni();
    b = in.ni();
    dp = new long[n][2];
    for (int i = 0; i < n; i++) {
      dp[i][0] = dp[i][1] = -1L;
    }
    out.println((recurse(0, 0) + recurse(0, 1)) % MOD);
  }

  private int n, a, b;
  private final long MOD = (long) 1e9 + 7;
  private long[][] dp;

  private long recurse(int playlist, int last) {
    if (playlist == n) return 1L;

    if (dp[playlist][last] != -1) return dp[playlist][last];

    long ans = 0;
    int limit = last == 0 ? b : a;
    for (int add = 1; add <= limit; add++) {
      if (playlist + add <= n) {
        ans += recurse(playlist + add, last ^ 1);
        ans %= MOD;
      }
    }
    return dp[playlist][last] = ans;
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
    try (TheDebutAlbum instance = new TheDebutAlbum()) {
      instance.solve();
    }
  }
}
