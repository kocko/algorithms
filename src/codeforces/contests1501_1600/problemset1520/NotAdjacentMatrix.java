package codeforces.contests1501_1600.problemset1520;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotAdjacentMatrix implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public NotAdjacentMatrix() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      if (n == 2) {
        out.println(-1);
        continue;
      }
      int[][] grid = new int[n][n];
      int next = 1;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if ((i + j) % 2 == 0) {
            grid[i][j] = next++;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if ((i + j) % 2 == 1) {
            grid[i][j] = next++;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          out.print(grid[i][j]);
          out.print(' ');
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
    try (NotAdjacentMatrix instance = new NotAdjacentMatrix()) {
      instance.solve();
    }
  }
}
