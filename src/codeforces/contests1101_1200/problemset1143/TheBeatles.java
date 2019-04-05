package codeforces.contests1101_1200.problemset1143;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheBeatles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long n = in.nl(), k = in.nl(), a = in.nl(), b = in.nl(), min = Long.MAX_VALUE, max = 0;
    for (long l = 1; l <= 100000; l++) {
      long moves = n * k / gcd(n * k, a + b + k * l);
      max = Math.max(moves, max);
      min = Math.min(moves, min);

      moves = n * k / gcd(n * k, a - b + k * l);
      max = Math.max(moves, max);
      min = Math.min(moves, min);
    }
    out.println(min + " " + max);
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
    try (TheBeatles instance = new TheBeatles()) {
      instance.solve();
    }
  }
}
