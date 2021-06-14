package usaco.year2015.usopen;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class PalindromicPaths implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PalindromicPaths() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PalindromicPaths(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
//    long start = System.currentTimeMillis();
//    dp = new long[n][n][n];
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//        for (int k = 0; k < n; k++) {
//          dp[i][j][k] = -1;
//        }
//      }
//    }
//    long ans = 0;
//    for (int r1 = 0; r1 < n; r1++) {
//      ans += recurse(r1, n - r1 - 1, r1);
//      ans %= MOD;
//    }
//    out.println(ans);
//    long end = System.currentTimeMillis();
//    out.println((end - start) + " ms");
    dp2 = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp2[i][j] = -1;
      }
    }
    out.println(recurse(0, n - 1));
  }

  private final long MOD = (long) 1e9 + 7;
  private final int[][] first  = new int[][]{{-1, 0}, {0, -1}};
  private final int[][] second = new int[][]{{ 1, 0}, {0,  1}};

  private int n;
  private char[][] grid;
  private long[][][] dp;

  private long[][] dp2;

  private long recurse(int r1, int r2) {
    if (r1 == r2) return 1;

    if (dp2[r1][r2] != -1) return dp2[r1][r2];

    int ans = 0;
    for (int c1 = 0; c1 < n; c1++) {
      int moves = n - (r1 + c1) - 1;
      int c2 = moves - r2 + n - 1;
      if (grid[r1][c1] == grid[r2][c2]) {
        ans += recurse(r1 + 1, r2);
        ans %= MOD;
        ans += recurse(r1, r2 - 1);
        ans %= MOD;
      }
    }
    return dp2[r1][r2] = ans;
  }

  private long recurse(int r1, int c1, int r2) {
    if (r1 == 0 && c1 == 0 && r2 == n - 1) return grid[0][0] == grid[n - 1][n - 1] ? 1 : 0;

    if (dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

    int moves = n - (r1 + c1) - 1;
    int c2 = moves - r2 + n - 1;
    long ans = 0;
    for (int[] d1 : first) {
      for (int[] d2 : second) {
        int x1 = r1 + d1[0], y1 = c1 + d1[1];
        int x2 = r2 + d2[0], y2 = c2 + d2[1];
        if (x1 >= 0 && x1 < n &&
            y1 >= 0 && y1 < n &&
            x2 >= 0 && x2 < n &&
            y2 >= 0 && y2 < n &&
            grid[x1][y1] == grid[x2][y2]) {
          ans += recurse(x1, y1, x2);
          ans %= MOD;
        }
      }
    }
    return dp[r1][c1][r2] = ans;
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
//    try (PalindromicPaths instance = new PalindromicPaths("palpath.in", "palpath.out")) {
    try (PalindromicPaths instance = new PalindromicPaths()) {
      instance.solve();
    }
  }
}
