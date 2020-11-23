package uva.volume007;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TheVindictiveCoach implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      int n = in.nextInt(), m = in.nextInt();
      dp = new long[n][n][2];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < 2; k++) {
            dp[i][j][k] = -1;
          }
        }
      }
      long result = 1;
      if (n > 2) {
        if (m == 1) {
          result = recurse(1, n - 3, 0);
        } else {
          result = recurse(m - 1, n - m, 0);
        }
      }
      out.println(result);
    }
  }

  private long[][][] dp;

  private long recurse(int smaller, int bigger, int move) {
    if (smaller + bigger == 0) return 1L;

    if (dp[smaller][bigger][move] != -1) return dp[smaller][bigger][move];

    long ans = 0;
    if (move == 0) {
      for (int i = 1; i <= smaller; i++) {
        ans += recurse(smaller - i, bigger + i - 1, 1);
      }
    } else {
      for (int i = 1; i <= bigger; i++) {
        ans += recurse(smaller + i - 1, bigger - i, 0);
      }
    }
    return dp[smaller][bigger][move] = ans;
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
    try (TheVindictiveCoach instance = new TheVindictiveCoach()) {
      instance.solve();
    }
  }
}
