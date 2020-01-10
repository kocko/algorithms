package codeforces.contests1201_1300.problemset1285;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FadiAndLcm implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    long x = in.nl();
    long[] result = new long[]{1L, x};
    for (long a = 2; a * a <= x; a++) {
      if (x % a == 0) {
        List<Long> factors = factorize((int) a);
        for (long factor : factors) {
          long b = (factor * x) / a;
          if (gcd(a, b) == factor) {
            if (Math.max(a, b) < result[1]) {
              result = new long[]{Math.min(a, b), Math.max(a, b)};
            }
          }
        }
      }
    }
    out.println(result[0] + " " + result[1]);
  }

  private int MAX_N = (int) 1e6;
  private long[] sieve = new long[MAX_N + 1];

  private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private void init() {
    for (int i = 1; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          sieve[(int) j] = i;
        }
      }
    }
  }

  private List<Long> factorize(long n) {
    List<Long> result = new ArrayList<>();
    result.add(1L);
    while (n > 1) {
      result.add(sieve[(int) n]);
      n /= sieve[(int) n];
    }
    return result;
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
    try (FadiAndLcm instance = new FadiAndLcm()) {
      instance.solve();
    }
  }
}
