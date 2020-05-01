package codeforces.contests1001_1100.problemset1077;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PicturesWithKittensHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni(), x = in.ni();
    long[] beauty = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      beauty[i] = in.nl();
    }
    final long oo = Long.MAX_VALUE / 8;
    long[][] dp = new long[n + 1][x + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -oo);
    }
    dp[0][0] = 0;
    for (int j = 1; j <= x; j++) {
      ArrayDeque<long[]> queue = new ArrayDeque<>();
      queue.addLast(new long[]{j - 1, dp[j - 1][j - 1]});
      for (int i = j; i <= n; i++) {
        while (queue.size() > 0 && queue.peekFirst()[0] < i - k) {
          queue.pollFirst();
        }
        dp[i][j] = queue.peekFirst()[1] + beauty[i];
        while (queue.size() > 0 && queue.peekLast()[1] <= dp[i][j - 1]) {
          queue.pollLast();
        }
        queue.addLast(new long[]{i, dp[i][j - 1]});
      }
    }
    long ans = -1;
    for (int i = 0; i < k; i++) {
      ans = Math.max(ans, dp[n - i][x]);
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
    try (PicturesWithKittensHard instance = new PicturesWithKittensHard()) {
      instance.solve();
    }
  }
}
