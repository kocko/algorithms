package codeforces.contests1401_1500.problemset1459;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class RowGCD implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    long[] a = new long[n];
    long[] b = new long[m];

    for (int i = 0; i < n; i++) a[i] = in.nl();
    for (int i = 0; i < m; i++) b[i] = in.nl();
    long g = 0;
    for (int i = 1; i < n; i++) {
      g = gcd(abs(a[i] - a[0]), g);
    }
    for (int i = 0; i < m; i++) {
      out.print(gcd(a[0] + b[i], g));
      out.print(' ');
    }
  }

  private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (RowGCD instance = new RowGCD()) {
      instance.solve();
    }
  }
}
