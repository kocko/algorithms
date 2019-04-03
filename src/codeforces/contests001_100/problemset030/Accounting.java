package codeforces.contests001_100.problemset030;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Accounting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int a = in.ni(), b = in.ni(), n = in.ni();
    int absa = Math.abs(a), absb = Math.abs(b);
    if (a == 0 && b == 0) {
      out.println(1);
    } else if (a == 0) {
      out.println("No solution");
    } else if (b == 0) {
      out.println(0);
    } else {
      int gcd = gcd(absa, absb);
      a /= gcd;
      b /= gcd;
      absa /= gcd;
      absb /= gcd;
      //a x^n = b;
      if (absb % absa != 0) {
        out.println("No solution");
      } else {
        int multiplier = 1;
        int value = b / a;
        if (value < 0) {
          if (n % 2 == 0) {
            out.println("No solution");
            return;
          } else {
            multiplier = -1;
          }
        }
        value = Math.abs(value);
        for (int i = 1; i <= value; i++) {
          int temp = 1;
          for (int j = 0; j < n; j++) {
            temp *= i;
            if (temp > value) break;
          }
          if (temp == value) {
            out.println(i * multiplier);
            return;
          }
        }
        out.println("No solution");
      }
    }
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
    try (Accounting instance = new Accounting()) {
      instance.solve();
    }
  }
}
