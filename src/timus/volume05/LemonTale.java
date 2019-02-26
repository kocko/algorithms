package timus.volume05;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LemonTale implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    if (k == 0) {
      out.println(1);
      return;
    }
    BigInteger[][] dp = new BigInteger[n][2];
    BigInteger[] sum = new BigInteger[n + 1];
    dp[0][0] = dp[0][1] = BigInteger.ONE;
    sum[0] = dp[0][0];
    sum[1] = dp[0][0].add(BigInteger.ONE);

    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0].add(dp[i - 1][1]);
      sum[i + 1] = sum[i].add(dp[i][0]);

      dp[i][1] = sum[i];
      if (i - k >= 0) dp[i][1] = dp[i][1].subtract(sum[i - k]);
    }
    out.println(dp[n - 1][0].add(dp[n - 1][1]));
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
    try (LemonTale instance = new LemonTale()) {
      instance.solve();
    }
  }
}
