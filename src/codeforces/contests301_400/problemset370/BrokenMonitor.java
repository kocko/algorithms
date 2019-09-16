package codeforces.contests301_400.problemset370;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BrokenMonitor implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] grid = new char[n][m];
    int[][] prefix = new int[n + 1][m + 1];
    int minRow = n + 1, minCol = m + 1, maxRow = -1, maxCol = -1;
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
      for (int j = 0; j < m; j++) {
        prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];
        if (grid[i][j] == 'w') {
          minRow = Math.min(i, minRow);
          minCol = Math.min(j, minCol);
          maxRow = Math.max(i, maxRow);
          maxCol = Math.max(j, maxCol);
          prefix[i + 1][j + 1]++;
        }
      }
    }
    int white = prefix[n][m];
    int size = Math.max(maxRow - minRow, maxCol - minCol) + 1;
    boolean ok = false;
    out:
    for (int row = 0; row <= n - size; row++) {
      for (int col = 0; col <= m - size; col++) {
        if (row + size > maxRow && col + size > maxCol) {
          int w = prefix[row + size][col + size] - prefix[row][col + size] - prefix[row + size][col] + prefix[row][col];
          if (size > 2) {
            int inner = prefix[row + size - 1][col + size - 1] - prefix[row + 1][col + size - 1] - prefix[row + size - 1][col + 1] + prefix[row + 1][col + 1];
            w -= inner;
          }
          if (w == white) {
            for (int i = row; i < row + size; i++) {
              for (int j = col; j < col + size; j++) {
                if (i == row || i == row + size - 1 || j == col || j == col + size - 1) {
                  if (grid[i][j] == '.') {
                    grid[i][j] = '+';
                  }
                }
              }
            }
            ok = true;
            break out;
          }
        }
      }
    }
    if (ok) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          out.print(grid[i][j]);
        }
        out.println();
      }
    } else {
      out.println(-1);
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
    try (BrokenMonitor instance = new BrokenMonitor()) {
      instance.solve();
    }
  }
}
