package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AfterTwoHares implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    int[][] rowNumber = new int[n][m];
    for (int i = 0; i < n; i++) {
      int current = 1;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '.') {
          rowNumber[i][j] = current;
        } else {
          current++;
        }
      }
    }
    int[][] colNumber = new int[n][m];
    for (int j = 0; j < m; j++) {
      int current = 1;
      for (int i = 0; i < n; i++) {
        if (grid[i][j] == '.') {
          colNumber[i][j] = current;
        } else {
          current++;
        }
      }
    }
    int q = in.ni();
    while (q-- > 0) {
      int r1 = in.ni() - 1, c1 = in.ni() - 1, r2 = in.ni() - 1, c2 = in.ni() - 1;
      boolean reach = false;
      if (grid[r1][c2] == '.') {
        reach = (rowNumber[r1][c1] == rowNumber[r1][c2] && colNumber[r1][c2] == colNumber[r2][c2]);
      }
      if (grid[r2][c1] == '.') {
        reach |= (colNumber[r2][c1] == colNumber[r1][c1] && rowNumber[r2][c1] == rowNumber[r2][c2]);
      }
      out.println(reach ? "YES" : "NO");
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
    try (AfterTwoHares instance = new AfterTwoHares()) {
      instance.solve();
    }
  }
}
