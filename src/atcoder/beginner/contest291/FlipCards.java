package atcoder.beginner.contest291;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlipCards implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public FlipCards() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    final long MOD = 998244353L;
    int[][] cards = new int[n][2];
    for (int i = 0; i < n; i++) {
      cards[i][0] = in.ni();
      cards[i][1] = in.ni();
    }
    long[] dp = {1L, 1L};
    for (int idx = n - 2; idx >= 0; idx--) {
      long[] next = new long[2];
      for (int side = 0; side < 2; side++) {
        for (int nextSide = 0; nextSide < 2; nextSide++) {
          if (cards[idx][side] != cards[idx + 1][nextSide]) {
            next[side] += dp[nextSide];
            next[side] %= MOD;
          }
        }
      }
      dp = next;
    }
    out.println((dp[0] + dp[1]) % MOD);
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
    try (FlipCards instance = new FlipCards()) {
      instance.solve();
    }
  }
}
