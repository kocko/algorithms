package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GreedyWalking implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int n;
    while ((n = in.ni()) != 0) {
      int[] start = new int[n], end = new int[n];
      for (int i = 0; i < n; i++) {
        start[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        end[i] = in.ni();
      }
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += end[i] - start[i];
      }
      long result = fact[sum] % MOD;
      for (int i = 0; i < n; i++) {
        result *= inverse[end[i] - start[i]];
        result %= MOD;
      }
      out.println(result);
    }
  }

  private long MOD = (long) 1e9 + 7;
  private long[] fact, inverse;

  private void init() {
    final int MAX_N = 50 * 500 + 5;
    fact = new long[MAX_N];
    inverse = new long[MAX_N];
    fact[0] = inverse[0] = 1;
    for (int i = 1; i < MAX_N; i++) {
      fact[i] = i * fact[i - 1] % MOD;
      inverse[i] = power(fact[i], MOD - 2);
    }
  }

  private long power(long a, long b) {
    if (b == 0) return 1L;
    long half = power(a, b >> 1), result = half * half % MOD;
    if (b % 2 == 1) {
      result *= a;
      result %= MOD;
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
    try (GreedyWalking instance = new GreedyWalking()) {
      instance.solve();
    }
  }
}
