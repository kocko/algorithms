package codeforces.contests1401_1500.problemset1433;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZeroRemainderSum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    k = in.ni();
    x = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        x[i][j] = in.ni();
      }
    }
    half = m / 2;
    dp = new int[n][m][half + 1][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int l = 0; l <= half; l++) {
          for (int o = 0; o < k; o++) {
            dp[i][j][l][o] = -1;
          }
        }
      }
    }
    out.println(recurse(0, 0, half, 0));
  }

  private int n, m, k, half;
  private int[][] x;
  private int[][][][] dp;

  private int recurse(int row, int col, int remaining, int mod) {
    if (row == n && col == 0) return mod == 0 ? 0 : -100000;

    if (dp[row][col][remaining][mod] != -1) return dp[row][col][remaining][mod];

    int nextCol = (col + 1) % m, nextRow = row;
    if (nextCol == 0) {
      nextRow++;
    }

    int ans = -100000;
    //take
    if (remaining > 0) {
      int nextMod = (mod + x[row][col]) % k;
      if (nextCol == 0) {
        ans = Math.max(ans, x[row][col] + recurse(nextRow, nextCol, half, nextMod));
      } else {
        ans = Math.max(ans, x[row][col] + recurse(nextRow, nextCol, remaining - 1, nextMod));
      }
    }

    //skip
    if (nextCol == 0) {
      ans = Math.max(ans, recurse(nextRow, nextCol, half, mod));
    } else {
      ans = Math.max(ans, recurse(nextRow, nextCol, remaining, mod));
    }


    return dp[row][col][remaining][mod] = ans;
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
    try (ZeroRemainderSum instance = new ZeroRemainderSum()) {
      instance.solve();
    }
  }
}
