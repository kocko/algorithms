package codeforces.gyms.gym409982;

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

import static java.lang.Math.*;

public class DigitFibonacci implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public DigitFibonacci() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      long n = in.nl();
      long[][] matrix = {{1, 1}, {1, 0}};
      long[][] result = power(matrix, n);
      out.println(result[0][1]);
    }
  }

  private final long MOD = 10;

  private long[][] multiply(long[][] a, long[][] b) {
    long[][] result = new long[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < a[0].length; k++) {
          result[i][j] += a[i][k] * b[k][j];
          result[i][j] %= MOD;
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
    try (DigitFibonacci instance = new DigitFibonacci()) {
      instance.solve();
    }
  }
}
