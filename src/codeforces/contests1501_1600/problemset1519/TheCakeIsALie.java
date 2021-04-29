package codeforces.contests1501_1600.problemset1519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheCakeIsALie implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public TheCakeIsALie() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    final int MAX_N = 100;
    int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    for (int i = 2; i <= MAX_N; i++) {
      grid[1][i] = i - 1;
      grid[i][1] = i - 1;
    }
    for (int i = 2; i <= MAX_N; i++) {
      for (int j = 2; j <= MAX_N; j++) {
        grid[i][j] = Math.min(grid[i - 1][j] + j, grid[i][j - 1] + i);
      }
    }
    int t = in.ni();
    while (t-- > 0) {
      int row = in.ni(), col = in.ni(), price = in.ni();
      out.println(price == grid[row][col] ? "YES" : "NO");
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
    try (TheCakeIsALie instance = new TheCakeIsALie()) {
      instance.solve();
    }
  }
}
