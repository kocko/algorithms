package uva.volume113;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Matches implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      n = in.nextInt();
      dp = new BigInteger[2001];
      for (int i = 0; i < 2001; i++) {
        dp[i] = MINUS_ONE;
      }
      BigInteger result = BigInteger.ZERO;
      if (matches[0] <= n) {
        result = result.add(BigInteger.ONE);
      }
      for (int i = 1; i <= 9; i++) {
        if (n >= matches[i]) {
          result = result.add(recurse(n - matches[i])).add(BigInteger.ONE);
        }
      }
      out.println(result);
    }
  }

  private int n;
  private final int[] matches = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
  private final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
  private BigInteger[] dp;

  private BigInteger recurse(int remaining) {
    if (remaining <= 1) return BigInteger.ZERO;

    if (!dp[remaining].equals(MINUS_ONE)) return dp[remaining];

    BigInteger result = BigInteger.ZERO;
    for (int i = 0; i <= 9; i++) {
      if (remaining >= matches[i]) {
        result = result.add(recurse(remaining - matches[i])).add(BigInteger.valueOf(1));
      }
    }

    return dp[remaining] = result;
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
    try (Matches instance = new Matches()) {
      instance.solve();
    }
  }
}
