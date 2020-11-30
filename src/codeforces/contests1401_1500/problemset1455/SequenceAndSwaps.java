package codeforces.contests1401_1500.problemset1455;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SequenceAndSwaps implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      int x = in.ni();
      a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      dp = new int[n][501][501];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j <= 500; j++) {
          for (int k = 0; k <= 500; k++) {
            dp[i][j][k] = -1;
          }
        }
      }
      int ans = recurse(0, x, 0);
      out.println(ans != oo ? ans : -1);
    }
  }

  private final int oo = 1000;
  private int n;
  private int[][][] dp;
  private int[] a;

  private int recurse(int idx, int x, int last) {
    if (idx == n) return 0;
    if (dp[idx][x][last] != -1) return dp[idx][x][last];

    int ans = oo;
    if (x >= last && x < a[idx]) {
      ans = Math.min(ans, 1 + recurse(idx + 1, a[idx], x));
    }
    if (a[idx] >= last) {
      ans = Math.min(ans, recurse(idx + 1, x, a[idx]));
    }
    return dp[idx][x][last] = ans;
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
    try (SequenceAndSwaps instance = new SequenceAndSwaps()) {
      instance.solve();
    }
  }
}
