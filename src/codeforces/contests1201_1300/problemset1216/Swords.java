package codeforces.contests1201_1300.problemset1216;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Swords implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] x = new long[n];
    long max = 0;
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      if (x[i] > max) {
        max = x[i];
      }
    }
    long loss = 0;
    for (int i = 0; i < n; i++) {
      loss += (max - x[i]);
    }
    long gcd = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] != max) {
        gcd = gcd(gcd, max - x[i]);
      }
    }

    out.print(loss / gcd);
    out.print(' ');
    out.print(gcd);
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
    try (Swords instance = new Swords()) {
      instance.solve();
    }
  }
}
