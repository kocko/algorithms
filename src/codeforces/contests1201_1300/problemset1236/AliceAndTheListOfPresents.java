package codeforces.contests1201_1300.problemset1236;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AliceAndTheListOfPresents implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long n = in.nl(), m = in.nl();
    long a = power(2, m);
    a--;
    if (a < 0) {
      a += MOD;
    }
    a = power(a, n);
    out.println(a % MOD);
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
    try (AliceAndTheListOfPresents instance = new AliceAndTheListOfPresents()) {
      instance.solve();
    }
  }
}
