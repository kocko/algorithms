package codeforces.contests1701_1800.problemset1791;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NegativesAndPositives implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public NegativesAndPositives() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      int neg = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        if (x[i] < 0) {
          neg ^= 1;
        }
      }
      long result = 0;
      if (neg == 1) {
        long min = Long.MAX_VALUE;
        int where = 0;
        for (int i = 0; i < n; i++) {
          if (Math.abs(x[i]) < min) {
            min = Math.abs(x[i]);
            where = i;
          }
        }
        for (int i = 0; i < n; i++) {
          if (i != where) {
            result += Math.abs(x[i]);
          } else {
            result -= Math.abs(x[i]);
          }
        }
      } else {
        for (int i = 0; i < n; i++) {
          result += Math.abs(x[i]);
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
    try (NegativesAndPositives instance = new NegativesAndPositives()) {
      instance.solve();
    }
  }
}
