package codeforces.contests1301_1400.problemset1365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MatrixGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] grid = new int[n][m];

      boolean[] row = new boolean[n];
      boolean[] col = new boolean[m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if ((grid[i][j] = in.ni()) == 1) {
            row[i] = col[j] = true;
          }
        }
      }
      int free = 0;
      for (int i = 0; i < n; i++) {
        if (!row[i]) {
          for (int j = 0; j < m; j++) {
            if (!col[j]) {
              free++;
              row[i] = col[j] = true;
              break;
            }
          }
        }
      }
      out.println(free % 2 == 1 ? "Ashish" : "Vivek");
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
    try (MatrixGame instance = new MatrixGame()) {
      instance.solve();
    }
  }
}
