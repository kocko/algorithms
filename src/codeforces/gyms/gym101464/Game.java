package codeforces.gyms.gym101464;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Game implements Closeable {

  private InputReader in;
  private PrintWriter out = new PrintWriter(System.out);

  public Game() throws IOException {
    in = new InputReader(new FileInputStream(new File("h.in")));
  }

  public void solve() {
    try {
      while (true) {
        int n = in.ni();
        row = new int[n + 1][n + 1];
        col = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            int next = in.ni() % 2;
            row[i + 1][j + 1] = row[i + 1][j] ^ next;
            col[j + 1][i + 1] = col[j + 1][i] ^ next;
          }
        }

        dp = new int[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= n; j++) {
            for (int k = 0; k < 2; k++) {
              dp[i][j][k] = -1;
            }
          }
        }
        int win = recurse(n, n, 0);
        out.println(win == 1 ? "W" : "L");
      }
    } catch (Exception e) {

    }
  }

  private int[][] row, col;

  private int[][][] dp;

  private int recurse(int r, int c, int player) {
    if (r == 0 || c == 0) return (byte) player;

    if (dp[r][c][player] != -1) return dp[r][c][player];

    int win;
    if (player == 0) {
      if (row[r][c] == 1 && col[c][r] == 1) {
        win = 0;
      } else {
        win = ((row[r][c] == 0 && (recurse(r - 1, c, 1) == 1)) || (col[c][r] == 0 && (recurse(r, c - 1, 1) == 1))) ? 1 : 0;
      }
    } else {
      if (row[r][c] == 1 && col[c][r] == 1) {
        win = 1;
      } else {
        win = ((row[r][c] == 1 || recurse(r - 1, c, 0) == 1) && (col[c][r] == 1 || recurse(r, c - 1, 0) == 1)) ? 1 : 0;
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
