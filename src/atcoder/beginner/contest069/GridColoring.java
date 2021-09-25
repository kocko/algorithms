package atcoder.beginner.contest069;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class GridColoring implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GridColoring() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public GridColoring(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int h = in.ni(), w = in.ni();
    int n = in.ni();
    int[] count = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      count[i] = in.ni();
    }
    int[][] result = new int[h][w];
    int idx = 0;
    for (int i = 0; i < h; i++) {
      if (i % 2 == 0) {
        for (int j = w - 1; j >= 0; j--) {
          if (count[idx] == 0) idx++;
          result[i][j] = idx;
          count[idx]--;
        }
      } else {
        for (int j = 0; j < w; j++) {
          if (count[idx] == 0) idx++;
          result[i][j] = idx;
          count[idx]--;
        }
      }
      for (int j = 0; j < w; j++) {
        out.print(result[i][j]);
        out.print(' ');
      }
      out.println();
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
    try (GridColoring instance = new GridColoring()) {
      instance.solve();
    }
  }
}
