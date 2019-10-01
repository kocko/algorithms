package codeforces.contests1201_1300.problemset1228;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimesAndMultiplication implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long x = in.nl(), n = in.nl();
    long result = 1L;
    List<Long> primes = factorize(x);
    for (long prime : primes) {
      long p = prime;
      BigInteger bi = BigInteger.valueOf(p);
      BigInteger N = BigInteger.valueOf(n);
      while (bi.compareTo(N) <= 0) {
        long times = n / p;
        result *= power(prime, times);
        result %= MOD;
        p *= prime;
        bi = bi.multiply(BigInteger.valueOf(prime));
      }
    }
    out.println(result);
  }

  private final long MOD = (long) 1e9 + 7;

  private long power(long a, long b) {
    if (b == 0) return 1L;
    long half = power(a, b >> 1) % MOD, result = half * half % MOD;
    if (b % 2 == 1) {
      result *= a;
      result %= MOD;
    }
    return result;
  }

  private List<Long> factorize(long n) {
    List<Long> result = new ArrayList<>();
    for (long i = 2L; i * i <= n; i++) {
      if (n % i == 0) {
        result.add(i);
        while (n % i == 0) {
          n /= i;
        }
      }
    }
    if (n > 1) {
      result.add(n);
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
    try (PrimesAndMultiplication instance = new PrimesAndMultiplication()) {
      instance.solve();
    }
  }
}
