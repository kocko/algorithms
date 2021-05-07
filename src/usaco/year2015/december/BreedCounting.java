package usaco.year2015.december;

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

public class BreedCounting implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public BreedCounting() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("bcount.in"));
    out = new PrintWriter(new FileOutputStream("bcount.out"));
  }

  public void solve() {
    int n = in.ni(), q = in.ni();
    int[][] prefix = new int[3][n + 1];
    for (int i = 1; i <= n; i++) {
      int type = in.ni();
      for (int j = 0; j < 3; j++) {
        prefix[j][i] = prefix[j][i - 1];
      }
      prefix[type - 1][i]++;
    }
    while (q-- > 0) {
      int left = in.ni(), right = in.ni();
      for (int type = 0; type < 3; type++) {
        int count = prefix[type][right] - prefix[type][left - 1];
        out.print(count);
        if (type < 2) {
          out.print(' ');
        }
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
    try (BreedCounting instance = new BreedCounting()) {
      instance.solve();
    }
  }
}
