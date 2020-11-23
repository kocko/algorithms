package uva.volume120;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZerosAndOnes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      n = in.ni();
      k = in.ni();
      if (n % 2 == 1 || k == 0) {
        out.printf("Case %d: %d\n", testCase, 0);
      } else {
        dp = new long[n][n / 2 + 1][k + 1];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j <= n / 2; j++) {
            for (int l = 0; l <= k; l++) {
              dp[i][j][l] = -1;
            }
          }
        }
        out.printf("Case %d: %d\n", testCase, recurse(1, 1, 1));
      }
    }
  }

  private int n, k;

  private long[][][] dp;

  private long recurse(int idx, int ones, int mod) {
    if (idx == n) return mod == 0 ? 1L : 0L;

    if (dp[idx][ones][mod] != -1) return dp[idx][ones][mod];

    long result = 0;
    int zeroes = idx - ones;
    if (ones + 1 <= n / 2) {
      result += recurse(idx + 1, ones + 1, (mod << 1 | 1) % k);
    }
    if (zeroes + 1 <= n / 2) {
      result += recurse(idx + 1, ones, (mod << 1) % k);
    }
    return dp[idx][ones][mod] = result;
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
    try (ZerosAndOnes instance = new ZerosAndOnes()) {
      instance.solve();
    }
  }
}
