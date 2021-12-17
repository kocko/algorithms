package codeforces.contests1601_1700.problemset1618;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class PaintTheArray implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PaintTheArray() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PaintTheArray(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      long even = 0, odd = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        if (i % 2 == 0) {
          even = gcd(even, x[i]);
        } else {
          odd = gcd(odd, x[i]);
        }
      }
      if (even == 1 && odd == 1) {
        out.println(0);
      } else {
        long result = odd;
        for (int i = 0; i < n; i += 2) {
          if (x[i] % odd == 0) {
            result = 0;
            break;
          }
        }
        if (result == 0) {
          result = even;
          for (int i = 1; i < n; i += 2) {
            if (x[i] % even == 0) {
              result = 0;
              break;
            }
          }
        }
        out.println(result);
      }
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
    try (PaintTheArray instance = new PaintTheArray()) {
      instance.solve();
    }
  }
}
