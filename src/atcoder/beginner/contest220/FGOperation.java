package atcoder.beginner.contest220;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FGOperation implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FGOperation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    final long MOD = 998244353L;
    int n = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    long[] dp = new long[10];
    dp[a[0]] = 1L;
    for (int idx = 1; idx < n; idx++) {
      long[] dp2 = new long[10];
      for (int i = 0; i < 10; i++) {
        int prod = (a[idx] * i) % 10;
        int sum  = (a[idx] + i) % 10;
        dp2[prod] += dp[i];
        dp2[prod] %= MOD;
        dp2[sum] += dp[i];
        dp2[sum] %= MOD;
      }
      dp = dp2;
    }
    for (int i = 0; i < 10; i++) {
      out.println(dp[i]);
    }
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
    try (FGOperation instance = new FGOperation()) {
      instance.solve();
    }
  }
}
