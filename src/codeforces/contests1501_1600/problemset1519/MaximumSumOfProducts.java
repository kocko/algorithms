package codeforces.contests1501_1600.problemset1519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSumOfProducts implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MaximumSumOfProducts() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public MaximumSumOfProducts(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    a = new long[n];
    b = new long[n];
    for (int i = 0; i < n; i++) a[i] = in.nl();
    for (int i = 0; i < n; i++) b[i] = in.nl();

    dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
    long[] prefix = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] + a[i - 1] * b[i - 1];
    }
    long result = 0;
    for (int left = 0; left <= n; left++) {
      for (int right = n; right > left; right--) {
        long suffix = prefix[n] - prefix[right];
        long reverse = recurse(left, right - 1);
        result = Math.max(prefix[left] + reverse + suffix, result);
      }
    }
    out.println(result);
  }

  private int n;
  private long[] a, b;
  private long[][] dp;

  private long recurse(int left, int right) {
    if (left == right - 1) return a[left] * b[right] + a[left + 1] * b[right - 1];
    if (left == right) return a[left] * b[right];
    if (left > right) return 0;

    if (dp[left][right] != -1) return dp[left][right];

    return dp[left][right] = a[left] * b[right] + a[right] * b[left] + recurse(left + 1, right - 1);
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
    try (MaximumSumOfProducts instance = new MaximumSumOfProducts()) {
      instance.solve();
    }
  }
}
