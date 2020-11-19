package codeforces.contests1401_1500.problemset1452;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RadioTowers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] dp = new long[n + 2];
    dp[0] = 0;
    dp[1] = 1;
    long even = 0, odd = 1;
    for (int i = 2; i <= n + 1; i++) {
      if (i % 2 == 0) {
        dp[i] += odd;
        dp[i] %= MOD;
        even += dp[i];
        even %= MOD;
      } else {
        dp[i] += even;
        dp[i] %= MOD;
        odd += dp[i];
        odd %= MOD;
      }
    }
    long[] two = new long[n + 1];
    two[0] = 1;
    for (int i = 1; i <= n; i++) {
      two[i] = (two[i - 1] << 1) % MOD;
    }
    out.println(dp[n + 1] * power(two[n], MOD - 2) % MOD);
  }

  private final long MOD = 998244353;

  private long power(long x, long p) {
    if (p == 0) return 1L;
    if (p == 1) return x;

    long half = power(x, p / 2);
    long result = half * half % MOD;
    if (p % 2 == 1) {
      result = (result * x) % MOD;
    }
    return result;
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
    try (RadioTowers instance = new RadioTowers()) {
      instance.solve();
    }
  }
}
