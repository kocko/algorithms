package codeforces.contests1201_1300.problemset1234;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pipes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      n = in.ni();
      grid = new char[2][n];
      for (int i = 0; i < 2; i++) {
        grid[i] = in.next().toCharArray();
      }
      dp = new Boolean[2][n][3];
      out.println(recurse(0, 0, LEFT) ? "YES" : "NO");
    }
  }

  private int n;
  private char[][] grid;
  private Boolean[][][] dp;
  private final int LEFT = 0, UP = 1, DOWN = 2;

  private boolean recurse(int row, int col, int direction) {
    if (row >= 2 || row < 0) return false;
    if (col == n) return row == 1;

    if (dp[row][col][direction] != null) return dp[row][col][direction];

    boolean ans;

    int value = grid[row][col] - '0';

    if (direction == 0) { //coming from the left
      if (value == 1 || value == 2) {
        ans = recurse(row, col + 1, LEFT);
      } else {
        if (row == 0) {
          ans = recurse(row + 1, col, UP);
        } else {
          ans = recurse(row - 1, col, DOWN);
        }
      }
    } else if (direction == 1) { //coming from above
      if (value == 1 || value == 2) {
        ans = recurse(row + 1, col, UP);
      } else {
        ans = recurse(row, col + 1, LEFT);
      }
    } else { //coming from below
      if (value == 1 || value == 2) {
        ans = recurse(row - 1, col, DOWN);
      } else {
        ans = recurse(row, col + 1, LEFT);
      }
    }
    return dp[row][col][direction] = ans;
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
    try (Pipes instance = new Pipes()) {
      instance.solve();
    }
  }
}
