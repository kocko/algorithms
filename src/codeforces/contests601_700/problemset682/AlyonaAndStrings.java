package codeforces.contests601_700.problemset682;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class AlyonaAndStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    int k = in.ni();
    a = in.next().toCharArray();
    b = in.next().toCharArray();
    dp = new int[2][n + 1][m + 1][k + 1];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j <= n; j++) {
        for (int l = 0; l <= m; l++)
          Arrays.fill(dp[i][j][l], -1);
      }
    }
    out.println(recurse(0, 0, 0, k));
  }

  private final int oo = 2000;
  private int n, m;
  private char[] a, b;

  private int[][][][] dp;

  public int recurse(int start, int i, int j, int terminations) {
    if (terminations < 0) return -oo;
    if (i == n || j == m) return 0;

    if (dp[start][i][j][terminations] != -1) return dp[start][i][j][terminations];

    int ans = 0;
    if (a[i] == b[j]) {
      ans = max(ans, 1 + recurse(1, i + 1, j + 1, terminations - (start ^ 1)));
    }
    ans = max(ans, recurse(0, i + 1, j + 1, terminations));
    ans = max(ans, max(recurse(0, i + 1, j, terminations), recurse(0, i, j + 1, terminations)));
    return dp[start][i][j][terminations] = ans;
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
    try (AlyonaAndStrings instance = new AlyonaAndStrings()) {
      instance.solve();
    }
  }
}
