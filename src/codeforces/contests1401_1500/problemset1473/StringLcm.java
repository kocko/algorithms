package codeforces.contests1401_1500.problemset1473;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringLcm implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      char[] y = in.next().toCharArray();
      StringBuilder s = new StringBuilder();
      int lcm = lcm(x.length, y.length);
      for (int i = 0; i < lcm; i++) {
        s.append(x[i % x.length]);
      }
      boolean ok = true;
      for (int i = 0; i < lcm; i++) {
        ok &= s.charAt(i) == y[i % y.length];
      }
      out.println(ok ? s.toString() : "-1");
    }
  }

  private int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  private int gcd(int a, int b) {
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
    try (StringLcm instance = new StringLcm()) {
      instance.solve();
    }
  }
}
