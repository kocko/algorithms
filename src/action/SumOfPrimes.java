package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumOfPrimes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    sieve();
    long[] prefix = new long[MAX + 1];
    for (int i = 1; i <= MAX; i++) {
      prefix[i] = prefix[i - 1];
      if (prime[i]) {
        prefix[i] += i;
      }
    }
    int q = in.ni();
    while (q-- > 0) {
      int left = in.ni(), right = in.ni();
      out.println(prefix[right] - prefix[left - 1]);
    }
  }

  private final int MAX = 10000000;
  private boolean[] prime = new boolean[MAX + 1];

  private void sieve() {
    for (int i = 0; i <= MAX; i++) {
      prime[i] = true;
    }
    prime[0] = prime[1] = false;
    for (int i = 2; i <= MAX; i++) {
      if (prime[i]) {
        for (int j = i + i; j <= MAX; j += i) {
          prime[j] = false;
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
    try (SumOfPrimes instance = new SumOfPrimes()) {
      instance.solve();
    }
  }
}
