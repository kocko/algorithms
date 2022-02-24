package codeforces.contests1501_1600.problemset1542;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangeFunction implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public StrangeFunction() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private final long MOD = (long) 1e9 + 7, MAX_F = 41;
  private final long[] DIVISORS = {2, 3, 2, 5, 7, 2, 3, 11, 13, 2, 17, 19, 23, 5, 3, 29, 31, 2, 37, 41};

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl(), result = 0;
      long product = 1L, prev = 0L;
      int idx = 0;
      while (prev <= MAX_F) {
        long f;
        for (f = 2; f <= MAX_F; f++) {
          if (product % f != 0) break;
        }
        long count = n / product;
        long contribution = f - prev;
        prev = f;
        result += (count * contribution);
        result %= MOD;
        if (idx < DIVISORS.length) {
          product *= DIVISORS[idx++];
        }
      }
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
    try (StrangeFunction instance = new StrangeFunction()) {
      instance.solve();
    }
  }
}
