package timus.volume05;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneTwoOneTwo2 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    if (n <= 2) {
      out.println(n);
      return;
    }
    dp = new byte[31][n];
    next = new int[31][n];
    for (int i = 0; i < 31; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
    String result = null;
    for (int i = 1; i <= 2; i++) {
      int length = 1 + recurse(1, i);
      if (length != 101) {
        String tmp = restore(i, i);
        if (result == null) {
          result = tmp;
        } else {
          if (tmp.length() < result.length()) {
            result = tmp;
          }
        }
      }
    }
    out.println(result == null ? "Impossible" : result);
  }

  private int n;
  private byte[][] dp;
  private int[][] next;

  private byte recurse(int idx, int mod) {
    if (idx == 31) return 100;
    if (mod == 0) return 0;

    if (dp[idx][mod] != -1) return dp[idx][mod];

    byte ans = 100;
    for (int i = 1; i <= 2; i++) {
      byte minimize = (byte) (1 + recurse(idx + 1, (mod * 10 + i) % n));
      if (minimize < ans) {
        ans = minimize;
        next[idx][mod] = i;
      }
    }

    return dp[idx][mod] = ans;
  }

  private String restore(int start, int mod) {
    StringBuilder result = new StringBuilder();
    result.append(start);
    int idx = 1;
    while (next[idx][mod] != 0) {
      int digit = next[idx][mod];
      result.append(digit);
      mod = (10 * mod + digit) % n;
      idx++;
    }
    return result.toString();
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
    try (OneTwoOneTwo2 instance = new OneTwoOneTwo2()) {
      instance.solve();
    }
  }
}
