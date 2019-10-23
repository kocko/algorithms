package lightoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class MathematicallyHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    phi();
    int t = in.ni(), testCase = 1;
    while (t-- > 0) {
      int left = in.ni(), right = in.ni();
      BigInteger ans = sieve[right].add(sieve[left - 1].multiply(MINUS_ONE));
      out.println("Case " + testCase++ + ": " + ans.toString());
    }
  }

  private final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
  private int MAX_N = (int) 5e6;
  private BigInteger[] sieve = new BigInteger[MAX_N + 1];

  private void phi() {
    for (int i = 0; i <= MAX_N; i++) {
      sieve[i] = BigInteger.valueOf(i);
    }
    for (int i = 1; i <= MAX_N; i++) {
      for (int j = 2 * i; j <= MAX_N; j += i) {
        sieve[j] = sieve[j].add(sieve[i].multiply(MINUS_ONE));
      }
    }
    for (int i = 1; i <= MAX_N; i++) {
      sieve[i] = (sieve[i].multiply(sieve[i])).add(sieve[i - 1]);
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
    try (MathematicallyHard instance = new MathematicallyHard()) {
      instance.solve();
    }
  }
}
