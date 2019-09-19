package projecteuler;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SummationOfPrimes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int MAX_N = 1000000;
    boolean[] prime = new boolean[MAX_N + 1];
    for (int i = 2; i <= MAX_N; i++) {
      prime[i] = true;
    }
    for (long i = 2; i <= MAX_N; i++) {
      if (prime[(int) i]) {
        for (long j = i * i; j <= MAX_N; j += i) {
          prime[(int) j] = false;
        }
      }
    }
    long[] sum = new long[MAX_N + 1];
    for (int i = 2; i <= MAX_N; i++) {
      sum[i] = sum[i - 1];
      if (prime[i]) {
        sum[i] += i;
      }
    }
    int t = in.ni();
    while (t-- > 0) {
      out.println(sum[in.ni()]);
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
    try (SummationOfPrimes instance = new SummationOfPrimes()) {
      instance.solve();
    }
  }
}
