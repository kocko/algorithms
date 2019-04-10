package google.codejam2019.qualification;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Cryptopangrams implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int tests = in.ni();
    for (int testCase = 1; testCase <= tests; testCase++) {
      BigInteger max = new BigInteger(in.next());
      int n = in.ni();
      BigInteger[] x = new BigInteger[n];
      for (int i = 0; i < n; i++) {
        x[i] = new BigInteger(in.next());
      }
      BigInteger[] y = new BigInteger[n + 1];
      int i;
      for (i = 1; i < n; i++) {
        if (!x[i].equals(x[i - 1])) {
          y[i] = gcd(x[i], x[i - 1]);
          for (int j = i - 1; j >= 0; j--) {
            y[j] = x[j].divide(y[j + 1]);
          }
          break;
        }
      }
      while (i <= n) {
        y[i] = x[i - 1].divide(y[i - 1]);
        i++;
      }
      Set<BigInteger> primes = new TreeSet<>(Arrays.asList(y).subList(0, n + 1));
      Map<BigInteger, Character> map = new HashMap<>();
      int idx = 0;
      for (BigInteger prime : primes) {
        map.put(prime, (char) ('A' + idx++));
      }
      out.printf("Case #%d: ", testCase);
      for (BigInteger value : y) {
        out.print(map.get(value));
      }
      out.println();
    }
  }
  
  private BigInteger gcd(BigInteger a, BigInteger b) {
    return (b.equals(BigInteger.ZERO)) ? a : gcd(b, a.mod(b));
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
    try (Cryptopangrams instance = new Cryptopangrams()) {
      instance.solve();
    }
  }
}
