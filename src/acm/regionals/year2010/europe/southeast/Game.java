package acm.regionals.year2010.europe.southeast;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      int n = in.nextInt();
      int[][] grid = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = in.nextInt();
        }
      }
      row = new int[n + 1][n + 1];
      col = new int[n + 1][n + 1];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int parity = grid[i][j] % 2;
          row[i + 1][j + 1] = row[i + 1][j] ^ parity;
        }
      }
      for (int j = 0; j < n; j++) {
        for (int i = 0; i < n; i++) {
          int parity = grid[i][j] % 2;
          col[j + 1][i + 1] = col[j + 1][i] ^ parity;
        }
      }
      dp = new Boolean[n + 1][n + 1][2];
      boolean win = recurse(n, n, 0);
      out.println(win ? "W" : "L");
    }
  }

  private int[][] row, col;

  private Boolean[][][] dp;

  private boolean recurse(int r, int c, int player) {
    if (r == 0 || c == 0) return player == 1;

    if (dp[r][c][player] != null) return dp[r][c][player];

    boolean win;
    if (player == 0) {
      if (row[r][c] == 1 && col[c][r] == 1) {
        win = false;
      } else {
        win = (row[r][c] == 0 && recurse(r - 1, c, 1)) || (col[c][r] == 0 && recurse(r, c - 1, 1));
      }
    } else {
      if (row[r][c] == 1 && col[c][r] == 1) {
        win = true;
      } else {
        win = (row[r][c] == 1 || recurse(r - 1, c, 0)) && (col[c][r] == 1 || recurse(r, c - 1, 0));
      }
    }
    return dp[r][c][player] = win;
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
    try (Game instance = new Game()) {
      instance.solve();
    }
  }
}
