package codeforces.contests1401_1500.problemset1409;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimumProduct implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long a = in.nl(), b = in.nl(), x = in.nl(), y = in.nl(), n = in.nl();
      long result = Long.MAX_VALUE;
      long d1 = Math.min(a - x, n), rem1 = n - d1;
      long a1 = a - d1, b1 = Math.max(b - rem1, y);
      result = Math.min(result, a1 * b1);

      long d2 = Math.min(b - y, n), rem2 = n - d2;
      long a2 = Math.max(a - rem2, x), b2 = b - d2;
      result = Math.min(result, a2 * b2);

      out.println(result);
    }
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
    try (MinimumProduct instance = new MinimumProduct()) {
      instance.solve();
    }
  }
}
