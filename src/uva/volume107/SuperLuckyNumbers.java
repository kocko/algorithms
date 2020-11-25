package uva.volume107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SuperLuckyNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int b, n;
    dp = new BigInteger[129][101][2];
    while ((b = in.ni()) != 0 | (n = in.ni()) != 0) {
      if (n > 1) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i < b; i++) {
          if (i == 1) {
            result = result.add(recurse(b, n - 1, 1));
          } else {
            result = result.add(recurse(b, n - 1, 0));
          }
        }
        out.println(result);
      } else {
        out.println(b - 1);
      }
    }
  }

  private BigInteger[][][] dp;

  private BigInteger recurse(int base, int remaining, int lastIsOne) {
    if (remaining == 0) return BigInteger.ONE;

    if (dp[base][remaining][lastIsOne] != null) return dp[base][remaining][lastIsOne];

    BigInteger ans = BigInteger.ZERO;
    if (lastIsOne == 1) {
      for (int digit = 0; digit < base; digit++) {
        if (digit == 1) {
          ans = ans.add(recurse(base, remaining - 1, 1));
        } else if (digit != 3) {
          ans = ans.add(recurse(base, remaining - 1, 0));
        }
      }
    } else {
      for (int i = 0; i < base; i++) {
        if (i == 1) {
          ans = ans.add(recurse(base, remaining - 1, 1));
        } else {
          ans = ans.add(recurse(base, remaining - 1, 0));
        }
      }
    }
    return dp[base][remaining][lastIsOne] = ans;
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
    try (SuperLuckyNumbers instance = new SuperLuckyNumbers()) {
      instance.solve();
    }
  }
}
