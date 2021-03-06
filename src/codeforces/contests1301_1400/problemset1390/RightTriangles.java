package codeforces.contests1301_1400.problemset1390;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RightTriangles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    long[][] up = new long[n][m], down = new long[n][m], left = new long[n][m], right = new long[n][m];
    for (int i = 0; i < n; i++) {
      int current = 0;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '*') {
          left[i][j] = current++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      int current = 0;
      for (int j = m - 1; j >= 0; j--) {
        if (grid[i][j] == '*') {
          right[i][j] = current++;
        }
      }
    }
    for (int j = 0; j < m; j++) {
      int current = 0;
      for (int i = 0; i < n; i++) {
        if (grid[i][j] == '*') {
          up[i][j] = current++;
        }
      }
    }
    for (int j = 0; j < m; j++) {
      int current = 0;
      for (int i = n - 1; i >= 0; i--) {
        if (grid[i][j] == '*') {
          down[i][j] = current++;
        }
      }
    }
    long result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '*') {
          result += up[i][j] * left[i][j];
          result += up[i][j] * right[i][j];
          result += down[i][j] * left[i][j];
          result += down[i][j] * right[i][j];
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
    try (RightTriangles instance = new RightTriangles()) {
      instance.solve();
    }
  }
}
