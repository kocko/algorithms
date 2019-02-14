package codeforces.contests1101_1200.problemset1114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class FloodFill implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    c = new int[n];
    for (int i = 0; i < n; i++) c[i] = in.ni();
    dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    int ans = oo;
    int start = 0, end = 0;
    for (int i = 0; i < n; i++, end++) {
      if (c[start] != c[end]) {
        ans = min(ans, recurse(start, end - 1));
        start = end;
      }
    }
    out.println(ans == oo ? 0 : ans);
  }

  private int n, oo = (int) 1e6;
  private int[] c;

  private int[][] dp;

  private Integer recurse(int left, int right) {
    if (left == 0 && right == n - 1) return 0;
    if (dp[left][right] != -1) return dp[left][right];

    int ans = oo;

    int newLeft = left - 1;
    while (newLeft >= 0) {
      if (c[newLeft] != c[left - 1]) break;
      newLeft--;
    }
    newLeft++;
    if (newLeft < left) {
      int newRight = right + 1;
      while (newRight < n) {
        if (c[newRight] != c[newLeft]) break;
        newRight++;
      }
      newRight--;
      ans = min(ans, 1 + recurse(newLeft, newRight));
    }

    int newRight = right + 1;
    while (newRight < n) {
      if (c[newRight] != c[right + 1]) break;
      newRight++;
    }
    newRight--;
    if (newRight > right) {
      newLeft = left - 1;
      while (newLeft >= 0) {
        if (c[newRight] != c[newLeft]) break;
        newLeft--;
      }
      newLeft++;
      ans = min(ans, 1 + recurse(newLeft, newRight));
    }
    return dp[left][right] = ans;
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
    try (FloodFill instance = new FloodFill()) {
      instance.solve();
    }
  }
}
