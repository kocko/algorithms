package uva.volume113;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EnumeratingRationalNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    phi();
    long n;
    while ((n = in.nl()) != 0) {
      int left = 1, right = MAX_N, denominator = MAX_N;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (sieve[mid] >= n) {
          denominator = Math.min(denominator, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      long prev = denominator > 0 ? sieve[denominator - 1] : 0;
      n -= prev;
      int prime = findRelativePrime(denominator, (int) n);
      out.println(prime + "/" + denominator);
    }
  }

  private int MAX_N = 200000;
  private long[] sieve = new long[MAX_N + 1];

  private void phi() {
    for (int i = 0; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    sieve[0] = 1;
    for (int i = 1; i <= MAX_N; i++) {
      for (int j = 2 * i; j <= MAX_N; j += i) {
        sieve[j] -= sieve[i];
      }
    }
    for (int i = 1; i <= MAX_N; i++) {
      sieve[i] += sieve[i - 1];
    }
  }

  private int findRelativePrime(int n, int k) {
    int result = 0;
    for (int i = 1; k > 0 && i <= n; i++) {
      if (gcd(i, n) == 1) {
        k--;
        result = i;
      }
    }
    return result;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (EnumeratingRationalNumbers instance = new EnumeratingRationalNumbers()) {
      instance.solve();
    }
  }
}
