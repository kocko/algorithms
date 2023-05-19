package codeforces.contests1801_1900.problemset1829;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;

public class DontBlameMe implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public DontBlameMe() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      k = in.ni();
      dp = new long[n][1 << MAX_K];
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], -1);
      }
      nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = in.ni();
      }
      long result = 0;
      for (int i = 0; i < n; i++) {
        result += recurse(i + 1, nums[i]);
        result %= MOD;
      }
      out.println(result % MOD);
    }
  }

  private static final long MOD = (long) 1e9 + 7;
  private static final int MAX_K = 6;
  private int n, k;
  private int[] nums;
  private long[][] dp;

  private long recurse(int idx, int mask) {
    if (idx == n) return bitCount(mask) == k ? 1 : 0;

    if (dp[idx][mask] != -1) return dp[idx][mask];

    long result = 0;
    result += recurse(idx + 1, mask & nums[idx]);
    result %= MOD;
    result += recurse(idx + 1, mask);
    result %= MOD;

    return dp[idx][mask] = result;
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
    try (DontBlameMe instance = new DontBlameMe()) {
      instance.solve();
    }
  }
}
