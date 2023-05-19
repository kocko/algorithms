package codeforces.contests1801_1900.problemset1829;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TheLakes implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TheLakes() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      m = in.ni();
      grid = new int[n][m];
      visited = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          grid[i][j] = in.ni();
        }
      }
      int result = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] > 0 && !visited[i][j]) {
            result = max(result, dfs(i, j));
          }
        }
      }
      out.println(result);
    }
  }

  private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int n, m;
  private int[][] grid;
  private boolean[][] visited;

  private int dfs(int row, int col) {
    visited[row][col] = true;
    int result = grid[row][col];
    for (int[] d : DIR) {
      int x = row + d[0], y = col + d[1];
      if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 0 && !visited[x][y]) {
        result += dfs(x, y);
      }
    }
    return result;
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
    try (TheLakes instance = new TheLakes()) {
      instance.solve();
    }
  }
}
