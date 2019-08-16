package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlternatingSequences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] sign = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      if (x[i] < 0) {
        sign[i] = 1;
      }
    }
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (sign[i] != sign[j] && Math.abs(x[i]) > Math.abs(x[j])) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      if (dp[i] == 0) {
        dp[i] = 1;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, dp[i]);
    }
    out.println(ans);
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
    try (AlternatingSequences instance = new AlternatingSequences()) {
      instance.solve();
    }
  }
}
