package codeforces.contests101_200.problemset118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CaesarsLegions implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int foot = in.ni();
    int horse = in.ni();
    FOOT_MAX = in.ni();
    HORSE_MAX = in.ni();
    dp = new Integer[101][101][2];
    int result = (recurse(foot, horse, 0) + recurse(foot, horse, 1)) % MOD;
    out.println(result);
  }

  private final int MOD = (int) 1e8;
  private int FOOT_MAX, HORSE_MAX;
  private Integer[][][] dp;

  private int recurse(int f, int h, int type) {
    if (f + h == 0) return 1;

    if (dp[f][h][type] != null) return dp[f][h][type];

    int result = 0;
    if (type == 0) {
      for (int add = 1; add <= Math.min(h, HORSE_MAX); add++) {
        result += recurse(f, h - add, 1);
        result %= MOD;
      }
    } else {
      for (int add = 1; add <= Math.min(f, FOOT_MAX) ; add++) {
        result += recurse(f - add, h, 0);
        result %= MOD;
      }
    }
    return dp[f][h][type] = result;
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
    try (CaesarsLegions instance = new CaesarsLegions()) {
      instance.solve();
    }
  }
}
