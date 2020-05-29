package codeforces.contests1301_1400.problemset1359;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class MixingWater implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int testCases = in.ni();
    while (testCases-- > 0) {
      long h = in.nl(), c = in.nl(), t = in.nl();

      long a = h + c, b = 2;
      long cups = 2;
      if (h == t) {
        a = 0;
        b = 1;
        cups = 1;
      }

      if (h + c != 2 * t) {
        double d = (h - t) / (2. * t - h - c);
        long k = (long) Math.floor(d);
        if (k >= 0) {
          long moves = 2 * k + 1;
          long p = (k + 1) * h * b + k * c * b - b * t * moves, q = moves * a;

          if (p < q) {
            cups = moves;
            a = p / b;
            b = moves;
          } else if (p == q) {
            cups = min(cups, moves);
          }
        }

        k = (long) Math.ceil(d);
        if (k >= 0) {
          long moves = 2 * k + 1;
          long p = b * t * moves - b * (k + 1) * h - b * k * c, q = moves * a;
          if (p < q) {
            cups = moves;
          } else if (p == q) {
            cups = min(cups, moves);
          }
        }
      }
      out.println(cups);
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
    try (MixingWater instance = new MixingWater()) {
      instance.solve();
    }
  }
}
