package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AgainPalindromes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int tests = in.ni();
    while (tests-- > 0) {
      x = in.next().toCharArray();
      dp = new Long[x.length][x.length];
      out.println(recurse(0, x.length - 1));
    }
  }

  private char[] x;
  private Long[][] dp;

  private Long recurse(int left, int right) {
    if (left >= x.length || right < 0) return 0L;
    if (left == right - 1 || left == right + 1) return (x[left] == x[right]) ? 3L : 2L;
    if (left == right) return 1L;
    if (dp[left][right] != null) return dp[left][right];

    long ans;
    if (x[left] == x[right]) {
      ans = 1 + recurse(left + 1, right) + recurse(left, right - 1);
    } else {
      ans = recurse(left + 1, right) + recurse(left, right - 1) - recurse(left + 1, right - 1);
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
    try (AgainPalindromes instance = new AgainPalindromes()) {
      instance.solve();
    }
  }
}
