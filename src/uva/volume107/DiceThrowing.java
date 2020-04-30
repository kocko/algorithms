package uva.volume107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiceThrowing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while ((n = in.ni()) != 0 | (x = in.ni()) != 0) {
      dp = new Long[n][6 * n + 1];
      long p = recurse(0, 0);
      long two = n, three = n;
      for (int i = 0; i < n; i++) {
        if (p % 2 == 0) {
          p /= 2;
          two--;
        }
        if (p % 3 == 0) {
          p /= 3;
          three--;
        }
      }
      long q = 1;
      for (int i = 0; i < two; i++) q *= 2;
      for (int i = 0; i < three; i++) q *= 3;
      if (p == 0) {
        out.println(0);
      } else if (q == 1) {
        out.println(p);
      } else {
        out.println(p + "/" + q);
      }
    }
  }

  private int n, x;
  private Long[][] dp;

  private long recurse(int idx, int sum) {
    if (idx == n) return sum >= x ? 1 : 0;

    if (dp[idx][sum] != null) return dp[idx][sum];

    long result = 0;
    for (int i = 1; i <= 6; i++) {
      result += recurse(idx + 1, sum + i);
    }
    return dp[idx][sum] = result;
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
    try (DiceThrowing instance = new DiceThrowing()) {
      instance.solve();
    }
  }
}
