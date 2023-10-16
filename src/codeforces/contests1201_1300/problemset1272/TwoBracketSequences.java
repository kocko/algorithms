package codeforces.contests1201_1300.problemset1272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoBracketSequences implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TwoBracketSequences() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    x = in.next().toCharArray();
    y = in.next().toCharArray();

    n = x.length;
    m = y.length;

    dp = new int[n + 1][m + 1][MAX_BALANCE + 1];
    next = new int[n + 1][m + 1][MAX_BALANCE + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        Arrays.fill(dp[i][j], -1);
        Arrays.fill(next[i][j], -1);
      }
    }
    recurse(0, 0, 0);
    restore();
  }

  private static final int MAX_BALANCE = 200;
  private static final int oo = 500;
  private static final char[] BRACKETS = {'(', ')'};
  private static final int[] BALANCE_DELTA = {1, -1};
  private static final int[] MASK_DELTA = {1, 0};
  private int n, m;
  private char[] x, y;
  private int[][][] dp;
  private int[][][] next;

  private int recurse(int i, int j, int balance) {
    if (balance > MAX_BALANCE) return oo;
    if (i == n && j == m && balance == 0) return 0;

    if (dp[i][j][balance] != -1) return dp[i][j][balance];

    int result = oo;

    if (i == n && j == m && balance > 0) {
      result = balance;
      next[i][j][balance] = 0;
    } else {
      for (int idx = 0; idx < 2; idx++) {
        int nextBalance = balance + BALANCE_DELTA[idx];
        if (nextBalance >= 0) {
          char ch = BRACKETS[idx];
          int mask = MASK_DELTA[idx];
          int nextI = i;
          if (i < n && x[i] == ch) {
            nextI = i + 1;
            mask |= 2;
          }
          int nextJ = j;
          if (j < m && y[j] == ch) {
            nextJ = j + 1;
            mask |= 4;
          }
          int move = 1 + recurse(nextI, nextJ, nextBalance);
          if (move < result) {
            result = move;
            next[i][j][balance] = mask;
          }
        }
      }
    }
    return dp[i][j][balance] = result;
  }

  private void restore() {
    int i = 0, j = 0, balance = 0;
    StringBuilder result = new StringBuilder();
    while (i != n || j != m || balance != 0) {
      int nxt = next[i][j][balance];
      char ch;
      if ((nxt & 1) != 0) {
        ch = '(';
        balance++;
      } else {
        ch = ')';
        balance--;
      }
      if ((nxt & 2) != 0) {
        i++;
      }
      if ((nxt & 4) != 0) {
        j++;
      }
      result.append(ch);
    }
    out.println(result);
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
    try (TwoBracketSequences instance = new TwoBracketSequences()) {
      instance.solve();
    }
  }
}
