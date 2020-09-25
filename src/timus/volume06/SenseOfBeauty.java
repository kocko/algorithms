package timus.volume06;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SenseOfBeauty implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    while (t-- > 0) {
      n = in.ni();
      first = in.next().toCharArray();
      second = in.next().toCharArray();
      firstPrefix = new int[n + 1];
      secondPrefix = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        firstPrefix[i] = (first[i - 1] - '0') + firstPrefix[i - 1];
        secondPrefix[i] = (second[i - 1] - '0') + secondPrefix[i - 1];
      }
      dp = new Boolean[n + 1][n + 1];
      next = new int[n + 1][n + 1];
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
          next[i][j] = -1;
        }
      }
      boolean ans = recurse(0, 0);
      if (ans) {
        restore();
      } else {
        out.println("Impossible");
      }
    }
  }

  private int n;
  private char[] first, second;
  private int[] firstPrefix, secondPrefix;
  private Boolean[][] dp;
  private int[][] next;

  private boolean recurse(int i, int j) {
    if (i + j == 2 * n) return true;

    if (dp[i][j] != null) return dp[i][j];

    boolean ans = false;
    int ones = firstPrefix[i] + secondPrefix[j], zeroes = i + j - ones;
    if (ones > zeroes) {
      if (i < n && first[i] == '0') {
        ans = recurse(i + 1, j);
        if (ans) {
          next[i][j] = 1;
        }
      }
      if (j < n && second[j] == '0') {
        ans |= recurse(i, j + 1);
        if (ans && next[i][j] == -1) {
          next[i][j] = 2;
        }
      }
    } else if (ones < zeroes) {
      if (i < n && first[i] == '1') {
        ans = recurse(i + 1, j);
        if (ans) {
          next[i][j] = 1;
        }
      }
      if (j < n && second[j] == '1') {
        ans |= recurse(i, j + 1);
        if (ans && next[i][j] == -1) {
          next[i][j] = 2;
        }
      }
    } else {
      if (i < n) {
        ans = recurse(i + 1, j);
        if (ans) {
          next[i][j] = 1;
        }
      }
      if (j < n) {
        ans |= recurse(i, j + 1);
        if (ans && next[i][j] == -1) {
          next[i][j] = 2;
        }
      }
    }

    return dp[i][j] = ans;
  }

  private void restore() {
    int i = 0, j = 0;
    StringBuilder result = new StringBuilder();
    while (i < n || j < n) {
      result.append(next[i][j]);
      if (next[i][j] == 1) {
        i++;
      } else {
        j++;
      }
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
    try (SenseOfBeauty instance = new SenseOfBeauty()) {
      instance.solve();
    }
  }
}
