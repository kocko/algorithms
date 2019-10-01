package codeforces.contests1201_1300.problemset1228;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FillingTheGrid implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int h = in.ni(), w = in.ni();
    int[] row = new int[h], col = new int[w];
    for (int i = 0; i < h; i++) {
      row[i] = in.ni();
    }
    for (int i = 0; i < w; i++) {
      col[i] = in.ni();
    }
    int[][] grid = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        grid[i][j] = -1;
      }
    }

    for (int i = 0; i < h; i++) {
      int value = row[i];
      if (value > 0) {
        for (int j = 0; j < value; j++) {
          grid[i][j] = 1;
        }
        if (value < w) {
          grid[i][value] = 0;
        }
      } else {
        grid[i][0] = 0;
      }
    }

    long result = 1L;
    for (int i = 0; i < w; i++) {
      int value = col[i];
      if (value > 0) {
        for (int j = 0; j < value; j++) {
          if (grid[j][i] == 0) {
            result = 0;
          } else {
            grid[j][i] = 1;
          }
        }
        if (value < h) {
          if (grid[value][i] == 1) {
            result = 0;
          } else {
            grid[value][i] = 0;
          }
        }
      } else {
        if (grid[0][i] == 1) {
          result = 0;
        } else {
          grid[0][i] = 0;
        }
      }
    }
    final int MOD = (int) 1e9 + 7;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (grid[i][j] == -1) {
          result = (result * 2) % MOD;
        }
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
    try (FillingTheGrid instance = new FillingTheGrid()) {
      instance.solve();
    }
  }
}
