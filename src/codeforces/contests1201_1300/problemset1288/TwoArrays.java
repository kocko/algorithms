package codeforces.contests1201_1300.problemset1288;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoArrays implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int m = in.ni();
    final long MOD = (long) 1e9 + 7;
    long[][] dp = new long[2001][2001];
    for (int i = 0; i <= 2000; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) dp[i][j] = 1L;
        else {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
          dp[i][j] %= MOD;
        }
      }
    }
    out.println(dp[n + 2 * m - 1][n - 1]);
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
    try (TwoArrays instance = new TwoArrays()) {
      instance.solve();
    }
  }
}
