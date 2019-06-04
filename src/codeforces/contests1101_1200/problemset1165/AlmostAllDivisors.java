package codeforces.contests1101_1200.problemset1165;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class AlmostAllDivisors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni();
      long min = (long) 1e6 + 5, max = 0;
      Set<Long> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        long next = in.nl();
        min = Math.min(min, next);
        max = Math.max(max, next);
        set.add(next);
      }
      long number = min * max;
      Set<Long> divisors = new HashSet<>();
      for (long divisor = 2; divisor <= Math.sqrt(number); divisor++) {
        if (number % divisor == 0) {
          divisors.add(divisor);
          divisors.add(number / divisor);
        }
      }
      boolean same = set.size() == divisors.size();
      for (long d : divisors) {
        same &= set.contains(d);
      }
      out.println(same ? number : -1);
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
    try (AlmostAllDivisors instance = new AlmostAllDivisors()) {
      instance.solve();
    }
  }
}
