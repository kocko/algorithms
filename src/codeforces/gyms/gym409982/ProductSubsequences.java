package codeforces.gyms.gym409982;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProductSubsequences implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ProductSubsequences() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    powers();
    binom();
    while (T-- > 0) {
      int n = in.ni();
      int positive = 0, negative = 0, zeroes = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (next > 0) {
          positive++;
        } else if (next < 0) {
          negative++;
        } else {
          zeroes++;
        }
      }
      out.printf("%d %d %d\n", P(positive, negative), N(positive, negative), Z(positive, negative, zeroes));
    }
  }

  private final int MAX_N = 1000;
  private final long MOD = (long) 1e9 + 7;
  private long[] powers;
  private long[][] binom;

  private void powers() {
    powers = new long[MAX_N + 1];
    powers[0] = 1L;
    for (int i = 1; i <= MAX_N; i++) {
      powers[i] = (2L * powers[i - 1]) % MOD;
    }
  }

  private void binom() {
    this.binom = new long[MAX_N + 1][MAX_N + 1];
    binom[0][0] = 1;
    for (int i = 1; i <= MAX_N; i++) {
      binom[i][0] = 1;
      for (int j = 1; j <= i; j++) {
        binom[i][j] = binom[i - 1][j] + binom[i - 1][j - 1];
        binom[i][j] %= MOD;
      }
    }
  }

  private long P(int positive, int negative) {
    long result = 0;

    for (int positiveSelected = 0; positiveSelected <= positive; positiveSelected++) {
      long waysForPositive = binom[positive][positiveSelected];
      for (int negativeSelected = 0; negativeSelected <= negative; negativeSelected += 2) {
        if (positiveSelected + negativeSelected == 0) continue;
        long waysForNegative = binom[negative][negativeSelected] % MOD;
        result += (waysForPositive * waysForNegative) % MOD;
        result %= MOD;
      }
    }

    return result;
  }

  private long N(int positive, int negative) {
    long result = 0;
    for (int positiveSelected = 0; positiveSelected <= positive; positiveSelected++) {
      long waysForPositive = binom[positive][positiveSelected];
      for (int negativeSelected = 1; negativeSelected <= negative; negativeSelected += 2) {
        long waysForNegative = binom[negative][negativeSelected];
        result += (waysForPositive * waysForNegative) % MOD;
        result %= MOD;
      }
    }
    return result;
  }

  private long Z(int positive, int negative, int zeroes) {
    long waysToSelectZero = (powers[zeroes] - 1 + MOD) % MOD;
    long waysToSelectNonZero = powers[negative + positive] % MOD;
    return waysToSelectZero * waysToSelectNonZero % MOD;
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
    try (ProductSubsequences instance = new ProductSubsequences()) {
      instance.solve();
    }
  }
}
