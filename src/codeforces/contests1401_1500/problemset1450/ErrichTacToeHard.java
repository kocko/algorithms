package codeforces.contests1401_1500.problemset1450;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ErrichTacToeHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[][] grid = new char[n][n];
      for (int i = 0; i < n; i++) {
        grid[i] = in.next().toCharArray();
      }
      int[] x = new int[3];
      int[] o = new int[3];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 'X') {
            x[(i + j) % 3]++;
          } else if (grid[i][j] == 'O') {
            o[(i + j) % 3]++;
          }
        }
      }
      int min = n * n, i = -1, j = -1;
      for (int k = 0; k < 3; k++) {
        for (int l = 0; l < 3; l++) {
          if (k != l) {
            if (x[k] + o[l] < min) {
              min = x[k] + o[l];
              i = k;
              j = l;
            }
          }
        }
      }
      for (int k = 0; k < n; k++) {
        for (int l = 0; l < n; l++) {
          if ((k + l) % 3 == i) {
            if (grid[k][l] == 'X') {
              out.print('O');
            } else {
              out.print(grid[k][l]);
            }
          } else if ((k + l) % 3 == j) {
            if (grid[k][l] == 'O') {
              out.print('X');
            } else {
              out.print(grid[k][l]);
            }
          } else {
            out.print(grid[k][l]);
          }
        }
        out.println();
      }
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
    try (ErrichTacToeHard instance = new ErrichTacToeHard()) {
      instance.solve();
    }
  }
}
