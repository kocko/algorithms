package codeforces.contests1301_1400.problemset1341;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NastyaAndScoreboard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final char[][] DIGITS = {
      "1110111".toCharArray(),
      "0010010".toCharArray(),
      "1011101".toCharArray(),
      "1011011".toCharArray(),
      "0111010".toCharArray(),
      "1101011".toCharArray(),
      "1101111".toCharArray(),
      "1010010".toCharArray(),
      "1111111".toCharArray(),
      "1111011".toCharArray()
    };
    int n = in.ni(), k = in.ni();
    int[][] cost = new int[n][10];
    for (int i = 0; i < n; i++) {
      char[] x = in.next().toCharArray();
      for (int digit = 0; digit < 10; digit++) {
        for (int pos = 0; pos < 7; pos++) {
          if (DIGITS[digit][pos] == '0' && x[pos] == '1') {
            cost[i][digit] = -1;
            break;
          }
          if (DIGITS[digit][pos] == '1' && x[pos] == '0') {
            cost[i][digit]++;
          }
        }
      }
    }

    boolean[][] dp = new boolean[n + 1][k + 1];
    dp[n][0] = true;
    for (int idx = n; idx > 0; idx--) {
      for (int remaining = 0; remaining <= k; remaining++) {
        if (dp[idx][remaining]) {
          for (int digit = 0; digit < 10; digit++) {
            int p = cost[idx - 1][digit];
            if (p != -1 && remaining + p <= k) {
              dp[idx - 1][remaining + p] = true;
            }
          }
        }
      }
    }
    if (!dp[0][k]) {
      out.println(-1);
    } else {
      for (int i = 0; i < n; i++) {
        int digit = -1;
        for (int d = 9; d >= 0; d--) {
          if (cost[i][d] != -1 && cost[i][d] <= k && dp[i + 1][k - cost[i][d]]) {
            k -= cost[i][d];
            digit = d;
            break;
          }
        }
        out.print(digit);
      }
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
    try (NastyaAndScoreboard instance = new NastyaAndScoreboard()) {
      instance.solve();
    }
  }
}
