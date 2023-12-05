package codeforces.contests1901_2000.problemset1902;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.sort;

public class InsertAndEqualize implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public InsertAndEqualize() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      long gcd = 0, max = Long.MIN_VALUE;
      Set<Long> has = new HashSet<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        has.add(x[i]);
        max = max(max, x[i]);
      }
      for (int idx = 0; idx < n; idx++) {
        gcd = gcd(gcd, max - x[idx]);
      }
      long result = 0;
      if (gcd == 0) {
        result = 1;
      } else {
        for (int idx = 0; idx < n; idx++) {
          result += (max - x[idx]) / gcd;
        }
        long tmp = max - gcd;
        while (has.contains(tmp)) {
          tmp -= gcd;
        }
        result += (max - tmp) / gcd;
      }
      out.println(result);
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
    try (InsertAndEqualize instance = new InsertAndEqualize()) {
      instance.solve();
    }
  }
}
