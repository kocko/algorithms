package codeforces.contests1401_1500.problemset1445;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Division implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long p = in.nl();
      int q = in.ni();
      long result = 0;
      List<Integer> primes = findPrimeDivisors(q);
      for (int d : primes) {
        long x = p;
        while (x % q == 0) {
          x /= d;
        }
        result = Math.max(result, x);
      }

      out.println(result);
    }
  }

  private List<Integer> findPrimeDivisors(int n) {
    List<Integer> divisors = new ArrayList<>();
    for (long k = 2; k * k <= n; k++) {
      if (n % k == 0) {
        divisors.add((int) k);
      }
      while (n % k == 0) {
        n /= k;
      }
    }
    if (n != 1) {
      divisors.add(n);
    }

    return divisors;
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
    try (Division instance = new Division()) {
      instance.solve();
    }
  }
}
