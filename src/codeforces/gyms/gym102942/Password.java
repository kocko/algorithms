package codeforces.gyms.gym102942;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Password implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      x = in.next().toCharArray();
      dp = new Long[n][10];
      out.println(recurse(0, 1));
    }
  }

  private long MOD = (long) 1e9 + 7;
  private int n;
  private Long[][] dp;
  private char[] x;

  private long recurse(int idx, int last) {
    if (idx == n) return 1;

    if (dp[idx][last] != null) return dp[idx][last];

    long ans = 0;
    char current = x[idx];
    if (current == '-') {
      for (int digit = last; digit <= 9; digit++) {
        ans += recurse(idx + 1, digit);
        ans %= MOD;
      }
    } else {
      int digit = current - '0';
      if (last > digit) {
        ans = 0;
      } else {
        ans = recurse(idx + 1, digit);
      }
    }
    return dp[idx][last] = ans;
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
    try (Password instance = new Password()) {
      instance.solve();
    }
  }
}
