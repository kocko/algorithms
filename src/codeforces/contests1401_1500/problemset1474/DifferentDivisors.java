package codeforces.contests1401_1500.problemset1474;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DifferentDivisors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    sieve();
    while (t-- > 0) {
      int d = in.ni();
      long result = 1;
      long last = 1L;
      for (int i = 0; i < 2; i++) {
        long next = primes.ceiling(last + d);
        result *= next;
        last = next;
      }
      out.println(result);
    }
  }

  private TreeSet<Long> primes = new TreeSet<>();

  private void sieve() {
    primes.add(1L);
    boolean[] sieve = new boolean[50000];
    Arrays.fill(sieve, true);
    for (long i = 2; i < sieve.length; i++) {
      if (sieve[(int) i]) {
        primes.add((long) i);
        for (long j = i * i; j < sieve.length; j += i) {
          sieve[(int) j] = false;
        }
      }
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
    try (DifferentDivisors instance = new DifferentDivisors()) {
      instance.solve();
    }
  }
}
