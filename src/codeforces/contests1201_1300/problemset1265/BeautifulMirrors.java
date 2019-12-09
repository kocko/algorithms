package codeforces.contests1201_1300.problemset1265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulMirrors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] p = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      p[i] = in.nl();
    }

    long[] prod = new long[n + 1];
    prod[0] = 1L;
    for (int i = 1; i <= n; i++) {
      long possibility = power(p[i], MOD - 2) * 100 % MOD;
      prod[i] = (prod[i - 1] * possibility + 1) % MOD;
    }
    out.println((prod[n] - 1 + MOD) % MOD);
  }

  private final int MOD = 998244353;

  private long power(long a, int p) {
    if (p == 0) return 1L;
    if (p == 1) return a;

    long half = power(a, p / 2) % MOD;
    long result = (half * half) % MOD;
    if (p % 2 == 1) {
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
    try (BeautifulMirrors instance = new BeautifulMirrors()) {
      instance.solve();
    }
  }
}
