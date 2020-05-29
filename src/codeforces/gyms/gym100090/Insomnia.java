package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Insomnia implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    out.println(recurse(in.ni()));
  }

  private Integer[] dp = new Integer[(int) 1e6 + 1];

  private int recurse(int n) {
    if (n <= 2) return 1;
    if (dp[n] != null) return dp[n];
    int ans = 1;
    for (int d = 2; d * d <= n; d++) {
      if (n % d == 0) {
        ans += recurse(n / d);
        if (d * d != n) {
          ans += recurse(d);
        }
      }
    }
    return dp[n] = ans;
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
    try (Insomnia instance = new Insomnia()) {
      instance.solve();
    }
  }
}
