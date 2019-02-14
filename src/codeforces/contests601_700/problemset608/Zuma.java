package codeforces.contests601_700.problemset608;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class Zuma implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    x = new int[n];
    dp = new Integer[n][n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    out.println(recurse(0, n - 1));
  }

  private int[] x;
  private Integer[][] dp;

  private int recurse(int left, int right) {
    if (left > right) return 0;
    if (left == right) return 1;

    if (dp[left][right] != null) return dp[left][right];

    int ans = 1000;
    if (x[left] == x[right]) {
      if (left == right - 1) {
        ans = 1;
      } else {
        ans = recurse(left + 1, right - 1);
      }
    }
    for (int mid = left; mid < right; mid++) {
      ans = min(ans, recurse(left, mid) + recurse(mid + 1, right));
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
    try (Zuma instance = new Zuma()) {
      instance.solve();
    }
  }
}
