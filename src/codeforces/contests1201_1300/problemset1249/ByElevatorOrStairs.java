package codeforces.contests1201_1300.problemset1249;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ByElevatorOrStairs implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    c = in.ni();
    stairs = new int[n];
    elevator = new int[n];
    for (int i = 1; i < n; i++) {
      stairs[i] = in.ni();
    }
    for (int i = 1; i < n; i++) {
      elevator[i] = in.ni();
    }
    dp = new Integer[n + 1][2];
    int[] result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      result[i] = recurse(i, 0);
    }
    for (int i = 1; i <= n; i++) {
      out.print(result[i]);
      out.print(' ');
    }
  }

  private Integer[][] dp;

  private int c;
  private int[] stairs, elevator;

  private Integer recurse(int idx, int used) {
    if (idx == 1) return 0;

    if (dp[idx][used] != null) return dp[idx][used];

    int ans = stairs[idx - 1] + recurse(idx - 1, 0);
    if (used == 1) {
      ans = Math.min(ans, elevator[idx - 1] + recurse(idx - 1, 1));
    } else {
      ans = Math.min(ans, elevator[idx - 1] + recurse(idx - 1, 1) + c);
    }
    return dp[idx][used] = ans;
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
    try (ByElevatorOrStairs instance = new ByElevatorOrStairs()) {
      instance.solve();
    }
  }
}
