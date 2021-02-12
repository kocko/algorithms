package codeforces.contests1401_1500.problemset1447;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumbersBox implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] grid = new int[n][m];
      int negative = 0;
      int minPositive = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          grid[i][j] = in.ni();
          if (grid[i][j] < 0) {
            negative++;
          }
          minPositive = Math.min(minPositive, Math.abs(grid[i][j]));
        }
      }
      int result = 0;
      if (negative % 2 == 0) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            result += Math.abs(grid[i][j]);
          }
        }
      } else {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (minPositive == Math.abs(grid[i][j])) {
              result -= minPositive;
              minPositive = 0;
            } else {
              result += Math.abs(grid[i][j]);
            }
          }
        }
      }
      out.println(result);
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
    try (NumbersBox instance = new NumbersBox()) {
      instance.solve();
    }
  }
}
