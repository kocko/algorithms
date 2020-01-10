package codeforces.contests1201_1300.problemset1285;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JustEatIt implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      long total = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        total += x[i];
      }
      long maxSoFar = Long.MIN_VALUE, maxEndingHere = 0;
      int end = n;
      for (int i = 0; i < n; i++) {
        maxEndingHere = maxEndingHere + x[i];
        if (maxSoFar < maxEndingHere) {
          maxSoFar = maxEndingHere;
          if (maxSoFar == total) {
            end = Math.min(end, i);
          }
        }
        if (maxEndingHere < 0) {
          maxEndingHere = 0;
        }
      }
      boolean happy = maxSoFar < total;
      if (maxSoFar == total) {
        int start = end;
        long temp = 0;
        while (temp < total) {
          temp += x[start];
          start--;
        }
        start++;
        happy = start == 0 && end == n - 1;
      }
      out.println(happy ? "YES" : "NO");
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
    try (JustEatIt instance = new JustEatIt()) {
      instance.solve();
    }
  }
}
