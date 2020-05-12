package codeforces.contests1301_1400.problemset1350;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OracAndFactors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX_N = (int) 1e6;
    long[] sieve = new long[MAX_N + 1];
    for (int i = 0; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          sieve[(int) j] = Math.min(sieve[(int) j], i);
        }
      }
    }
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl(), k = in.nl();
      long result = n;
      if (n % 2 == 1) {
        result += sieve[(int) n];
        k--;
      }
      result += 2 * k;
      out.println(result);
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
    try (OracAndFactors instance = new OracAndFactors()) {
      instance.solve();
    }
  }
}
