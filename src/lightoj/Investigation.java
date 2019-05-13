package lightoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Investigation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    for (int testCase = 1; testCase <= t; testCase++) {
      out.printf("Case %d: %d\n", testCase, f());
    }
  }

  private int f() {
    int a = in.ni(), b = in.ni();
    k = in.ni();
    if (k >= 100) return 0;
    return solve(b) - solve(a - 1);
  }

  private int solve(int a) {
    x = String.valueOf(a).toCharArray();
    n = x.length;
    dp = new int[10][100][100][2];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 100; j++) {
        for (int l = 0; l < 100; l++) {
          for (int m = 0; m < 2; m++) {
            dp[i][j][l][m] = -1;
          }
        }
      }
    }
    return recurse(0, 0, 0, 0);
  }

  private int k, n;
  private char[] x;

  private int[][][][] dp;

  private int recurse(int idx, int digitsRemainder, int numberRemainder, int smaller) {
    if (idx == n) return (digitsRemainder == 0 && numberRemainder == 0) ? 1 : 0;

    if (dp[idx][digitsRemainder][numberRemainder][smaller] != -1) return dp[idx][digitsRemainder][numberRemainder][smaller];

    int ans = 0;
    int limit = smaller == 1 ? 10 : x[idx] - '0';
    for (int digit = 0; digit < limit; digit++) {
      ans += recurse(idx + 1, (digitsRemainder + digit) % k, (10 * numberRemainder + digit) % k, 1);
    }
    if (smaller == 0) {
      ans += recurse(idx + 1, (digitsRemainder + x[idx] - '0') % k, (10 * numberRemainder + x[idx] - '0') % k, 0);
    }
    return dp[idx][digitsRemainder][numberRemainder][smaller] = ans;
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
    try (Investigation instance = new Investigation()) {
      instance.solve();
    }
  }
}
