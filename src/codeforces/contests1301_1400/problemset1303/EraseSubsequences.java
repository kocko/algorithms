package codeforces.contests1301_1400.problemset1303;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class EraseSubsequences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] s = in.next().toCharArray(), t = in.next().toCharArray();
      int n = s.length, m = t.length;
      int[][] next = new int[n + 3][26];
      for (int j = 0; j < 26; j++) {
        next[n][j] = next[n + 1][j] = next[n + 2][j] = n + 1;
      }
      for (int i = n; i >= 1; i--) {
        next[i][s[i - 1] - 'a'] = i;
        for (int j = 0; j < 26; j++) {
          next[i - 1][j] = next[i][j];
        }
      }

      boolean possible = false;
      for (int k = 0; k < m; k++) {
        int[][] dp = new int[k + 1][m - k + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
          dp[i][0] = next[dp[i - 1][0] + 1][t[i - 1] - 'a'];
        }
        for (int i = 1; i <= m - k; i++) {
          dp[0][i] = next[dp[0][i - 1] + 1][t[k + i - 1] - 'a'];
        }
        for (int i = 1; i <= k; i++) {
          for (int j = 1; j <= m - k; j++) {
            dp[i][j] = min(next[dp[i - 1][j] + 1][t[i - 1] - 'a'], next[dp[i][j - 1] + 1][t[k + j - 1] - 'a']);
          }
        }
        possible |= (dp[k][m - k] <= n);
      }
      out.println(possible ? "YES" : "NO");
    }
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
    try (EraseSubsequences instance = new EraseSubsequences()) {
      instance.solve();
    }
  }
}
