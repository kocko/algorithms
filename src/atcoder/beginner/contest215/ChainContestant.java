package atcoder.beginner.contest215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChainContestant implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ChainContestant() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public ChainContestant(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    x = in.next().toCharArray();
    final int MAX_K = 10;
    dp = new Long[n][1 << MAX_K][11];
    out.println(recurse(0, 0, 10));
  }

  private final long MOD = 998244353L;
  private int n;
  private char[] x;
  private Long[][][] dp;

  private long recurse(int idx, int mask, int last) {
    if (idx == n) return mask != 0 ? 1L : 0L;

    if (dp[idx][mask][last] != null) return dp[idx][mask][last];

    long ans = recurse(idx + 1, mask, last) % MOD;
    int here = x[idx] - 'A', bit = 1 << here;
    if ((mask & bit) == 0) {
      ans += recurse(idx + 1, mask | bit, here);
      ans %= MOD;
    } else if (last == here) {
      ans += recurse(idx + 1, mask, last);
      ans %= MOD;
    }
    return dp[idx][mask][last] = ans;
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
    try (ChainContestant instance = new ChainContestant()) {
      instance.solve();
    }
  }
}
