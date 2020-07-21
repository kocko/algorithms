package codeforces.gyms.gym102646;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.max;

public class TeamSelection implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    k = in.ni();
    a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
    }
    b = new long[k];
    for (int i = 0; i < k; i++) {
      b[i] = in.nl();
    }
    dp = new long[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        dp[i][j] = -1;
      }
    }
    out.println(recurse(0, 0));
  }

  private int n, k;
  private long[] a, b;
  private long[][] dp;

  private long recurse(int i, int j) {
    if (j == k) return 0;
    if (i == n) return (long) -1e15;

    if (dp[i][j] != -1) return dp[i][j];

    long skip = recurse(i + 1, j), take = 0;
    if (j < k) {
      take = a[i] * b[j] + recurse(i + 1, j + 1);
    }
    return dp[i][j] = max(take, skip);
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
    try (TeamSelection instance = new TeamSelection()) {
      instance.solve();
    }
  }
}
