package usaco.year2019.february;

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

public class PaintingTheBarn implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PaintingTheBarn() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("paintbarn.in"));
    out = new PrintWriter(new FileOutputStream("paintbarn.out"));
  }

  public void solve() {
    final int MAX_N = 1000;
    int n = in.ni(), k = in.ni();
    int[][] prefix = new int[MAX_N + 1][MAX_N + 1];
    while (n-- > 0) {
      int a = in.ni(), b = in.ni(), c = in.ni(), d = in.ni();
      prefix[a][b]++;
      prefix[a][d]--;
      prefix[c][b]--;
      prefix[c][d]++;
    }
    int result = 0;
    for (int row = 0; row < MAX_N; row++) {
      for (int col = 0; col < MAX_N; col++) {
        if (row > 0) prefix[row][col] += prefix[row - 1][col];
        if (col > 0) prefix[row][col] += prefix[row][col - 1];
        if (row > 0 && col > 0) prefix[row][col] -= prefix[row - 1][col - 1];
        if (prefix[row][col] == k) {
          result++;
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
    try (PaintingTheBarn instance = new PaintingTheBarn()) {
      instance.solve();
    }
  }
}
