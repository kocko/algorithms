package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Alphacode implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (true) {
      x = in.next().toCharArray();
      n = x.length;
      if (n == 1 && x[n - 1] == '0') break;
      dp = new Long[n];
      out.println(recurse(0));
    }
  }

  private int n;
  private char[] x;
  private Long[] dp;

  private long recurse(int idx) {
    if (idx == n) return 1;
    if (dp[idx] != null) return dp[idx];

    long ans = 0;
    if (x[idx] != '0') {
      ans += recurse(idx + 1);
      if (idx + 1 < n) {
        int code = 10 * (x[idx] - '0') + (x[idx + 1] - '0');
        if (code <= 26) {
          ans += recurse(idx + 2);
        }
      }
    }
    return dp[idx] = ans;
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
    try (Alphacode instance = new Alphacode()) {
      instance.solve();
    }
  }
}
