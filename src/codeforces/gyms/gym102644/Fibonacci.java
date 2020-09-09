package codeforces.gyms.gym102644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fibonacci implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long n = in.nl();
    out.println(power(new long[][]{{0, 1}, {1, 1}}, n)[1][0]);
  }

  private long[][] multiply(long[][] a, long[][] b) {
    final long MOD = (long) 1e9 + 7;
    long[][] result = new long[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) {
          result[i][k] += a[i][j] * b[j][k];
          result[i][k] %= MOD;
        }
      }
    }
    return result;
  }

  private long[][] power(long[][] matrix, long p) {
    int n = matrix.length;
    long[][] result = new long[n][n];
    for (int i = 0; i < n; i++) {
      result[i][i] = 1;
    }
    while (p > 0) {
      if (p % 2 == 1) {
        result = multiply(result, matrix);
      }
      matrix = multiply(matrix, matrix);
      p >>= 1;
    }
    return result;
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
    try (Fibonacci instance = new Fibonacci()) {
      instance.solve();
    }
  }
}
