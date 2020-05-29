package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;

public class JumpingAlongTheHummocks implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX_N = (int) 2e5;
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] dp = new int[n];
    int[] next = new int[MAX_N + 1];
    fill(next, -1);

    dp[n - 1] = 0;
    next[x[n - 1]] = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      int color = x[i];
      int nxt = next[color];
      dp[i] = 1 + dp[i + 1];
      if (nxt != -1) {
        dp[i] = Math.min(dp[i], 1 + dp[nxt]);
      }
      next[color] = i;
    }
    out.println(dp[0]);
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
    try (JumpingAlongTheHummocks instance = new JumpingAlongTheHummocks()) {
      instance.solve();
    }
  }
}
