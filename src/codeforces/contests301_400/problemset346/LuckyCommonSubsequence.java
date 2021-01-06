package codeforces.contests301_400.problemset346;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyCommonSubsequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    a = in.next().toCharArray();
    b = in.next().toCharArray();
    virus = in.next().toCharArray();
    n = a.length;
    m = b.length;
    k = virus.length;
    dp = new Integer[n][m][k];
    next = new String[n][m][k];
    kmp();
    int length = recurse(0, 0, 0);
    if (length <= 0) {
      out.println(0);
    } else {
      restore(length);
    }
  }

  private int n, m, k;
  private char[] a, b, virus;
  private Integer[][][] dp;
  private String[][][] next;
  private int[][] f;

  private void kmp() {
    int[] prefix = new int[k];
    for (int i = 1; i < k; i++) {
      int j = prefix[i - 1];
      while (j > 0 && virus[i] != virus[j]) {
        j = prefix[j - 1];
      }
      if (virus[i] == virus[j]) {
        j++;
      }
      prefix[i] = j;
    }
    f = new int[k][26];
    for (int i = 1; i < k; i++) {
      for (char c = 'A'; c <= 'Z'; c++) {
        if (virus[i] != c) {
          int j = prefix[i - 1];
          while (j > 0 && virus[j] != c) {
            j = prefix[j - 1];
          }
          if (c == virus[j]) {
            j++;
          }
          f[i][c - 'A'] = j;
        } else {
          f[i][c - 'A'] = prefix[i];
        }
      }
    }
  }

  private int recurse(int i, int j, int matched) {
    if (i == n || j == m) return 0;

    if (dp[i][j][matched] != null) return dp[i][j][matched];

    int ans = 0;
    if (a[i] == b[j]) {
      int m_ = a[i] == virus[matched] ? matched + 1 : f[matched][a[i] - 'A'];
      if (m_ < k) {
        ans = Math.max(ans, 1 + recurse(i + 1, j + 1, m_));
        next[i][j][matched] = s(i + 1, j + 1, m_);
      }
    }
    int p = recurse(i + 1, j, matched);
    int q = recurse(i, j + 1, matched);
    if (Math.max(p, q) > ans) {
      if (p >= q) {
        ans = p;
        next[i][j][matched] = s(i + 1, j, matched);
      } else {
        ans = q;
        next[i][j][matched] = s(i, j + 1, matched);
      }
    }
    return dp[i][j][matched] = ans;
  }

  private String s(int i, int j, int m) {
    return i + "_" + j + "_" + m;
  }

  private void restore(int length) {
    int i = 0, j = 0, matched = 0;
    StringBuilder result = new StringBuilder();
    while (result.length() < length) {
      String nxt = next[i][j][matched];
      String[] split = nxt.split("_");
      int i_ = Integer.parseInt(split[0]);
      int j_ = Integer.parseInt(split[1]);
      int m_ = Integer.parseInt(split[2]);
      if (i_ > i && j_ > j) {
        result.append(a[i]);
      }
      i = i_;
      j = j_;
      matched = m_;
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
    try (LuckyCommonSubsequence instance = new LuckyCommonSubsequence()) {
      instance.solve();
    }
  }
}
