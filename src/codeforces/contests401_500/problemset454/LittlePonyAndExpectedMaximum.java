package codeforces.contests401_500.problemset454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittlePonyAndExpectedMaximum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int m = in.ni(), n = in.ni();
    double[] p = new double[m + 1];
    for (int i = 1; i <= m; i++) {
      p[i] = power(((double) i) / m, n);
    }
    double result = 0;
    for (int i = 1; i <= m; i++) {
      result += i * (p[i] - p[i - 1]);
    }
    out.println(result);
  }

  private double power(double x, int p) {
    if (p == 0) return 1d;
    if (p == 1) return x;

    double half = power(x, p / 2);
    double result = half * half;
    if (p % 2 == 1) {
      result *= x;
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
    try (LittlePonyAndExpectedMaximum instance = new LittlePonyAndExpectedMaximum()) {
      instance.solve();
    }
  }
}
