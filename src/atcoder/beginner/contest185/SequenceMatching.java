package atcoder.beginner.contest185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SequenceMatching implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    a = new int[n];
    b = new int[m];
    for (int i = 0; i < n; i++) a[i] = in.ni();
    for (int i = 0; i < m; i++) b[i] = in.ni();
    dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j] = -1;
      }
    }
    out.println(recurse(0, 0));
  }

  private int n, m;
  private int[] a, b;
  private int[][] dp;

  private int recurse(int i, int j) {
    if (i == n) return (m - j);
    if (j == m) return (n - i);

    if (dp[i][j] != -1) return dp[i][j];

    int ans = Integer.MAX_VALUE;
    //delete from a
    if (i <= n - 1) ans = Math.min(ans, 1 + recurse(i + 1, j));
    //delete from b
    if (j <= m - 1) ans = Math.min(ans, 1 + recurse(i, j + 1));
    //don't delete, but check if the score increases in case of a[i] != b[j]
    ans = Math.min(ans, (a[i] != b[j] ? 1 : 0) + recurse(i + 1, j + 1));

    return dp[i][j] = ans;
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
    try (SequenceMatching instance = new SequenceMatching()) {
      instance.solve();
    }
  }
}
