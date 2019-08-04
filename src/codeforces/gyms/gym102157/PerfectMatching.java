package codeforces.gyms.gym102157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PerfectMatching implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    e = in.ni();
    int k = in.ni();
    forbidden = new boolean[2000][2000];
    for (int i = 0; i < k; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      forbidden[u][v] = true;
    }
    dp = new Integer[n][1 << 10];
    int bits = 2 * e + 1;
    int mask = ((1 << bits) - 1);
    ones = mask;
    for (int i = 0; i <= e; i++) {
      mask &= ~(1 << i);
    }
    firstBit = 1 << (bits - 1);
    out.println(recurse(0, mask));
  }
    
  private int n, e, firstBit, ones;
  private Integer[][] dp;
  private boolean[][] forbidden;
  
  private int recurse(int idx, int mask) {
    final int MOD = (int) 1e9 + 7;
    
    if (idx == n) return 1;
    if (dp[idx][mask] != null) return dp[idx][mask];
    
    int ans = 0;
    if ((mask & firstBit) == 0) {
      //we must match with the leftmost one
      int left = idx - e;
      if (left >= 0 && forbidden[idx][left]) {
        return 0;
      } else {
        mask |= firstBit;
        int nextMask = mask << 1;
        nextMask &= ones;
        ans = recurse(idx + 1, nextMask);
        ans %= MOD;
      }
    } else {
      //we could match with anyone
      int last = idx + e;
      for (int pair = Math.max(0, idx - e); pair <= Math.min(idx + e, n - 1); pair++) {
        int bit = last - pair;
        if (!forbidden[idx][pair] && (mask & (1 << bit)) == 0) {
          int nextMask = mask | (1 << bit);
          nextMask <<= 1;
          nextMask &= ones;
          ans += recurse(idx + 1, nextMask);
          ans %= MOD;
        }
      }
    }
    return dp[idx][mask] = ans;
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
    try (PerfectMatching instance = new PerfectMatching()) {
      instance.solve();
    }
  }
}
