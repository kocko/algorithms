package uva.volume114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      m = in.ni();
      dp = new Long[m + 1][n][1 << n];
      long ans = 0;
      for (int i = 1; i < n; i++) {
        ans += recurse(1, i, 1 << i);
        ans %= MOD;
      }
      out.println(ans);
    }
  }

  private int n, m;
  private final int MOD = (int) 1e9 + 7;
  private Long[][][] dp;

  private long recurse(int idx, int last, int mask) {
    if (idx > m) return 0;

    if (dp[idx][last][mask] != null) return dp[idx][last][mask];

    long ans = 0;

    if (mask == (1 << n) - 1) {
      ans++;
    }

    if (last >= 1) {
      int bit = 1 << (last - 1);
      ans += recurse(idx + 1, last - 1, mask | bit);
      ans %= MOD;
    }
    if (last + 1 < n) {
      int bit = 1 << (last + 1);
      ans += recurse(idx + 1, last + 1, mask | bit);
      ans %= MOD;
    }

    return dp[idx][last][mask] = ans;
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
    try (BeautifulNumbers instance = new BeautifulNumbers()) {
      instance.solve();
    }
  }
}
