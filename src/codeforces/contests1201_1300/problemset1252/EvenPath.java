package codeforces.contests1201_1300.problemset1252;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EvenPath implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), q = in.ni();
    int[] r = new int[n], c = new int[n];
    for (int i = 0; i < n; i++) {
      r[i] = in.ni();
    }
    for (int i = 0; i < n; i++) {
      c[i] = in.ni();
    }
    int[] rowIndex = new int[n];
    int current = 0;
    for (int i = 1; i < n; i++) {
      if ((r[i] % 2) != (r[i - 1] % 2)) {
        current++;
      }
      rowIndex[i] = current;
    }
    current = 0;
    int[] colIndex = new int[n];
    for (int i = 1; i < n; i++) {
      if ((c[i] % 2) != (c[i - 1] % 2)) {
        current++;
      }
      colIndex[i] = current;
    }
    while (q-- > 0) {
      int row1 = in.ni() - 1, col1 = in.ni() - 1;
      int row2 = in.ni() - 1, col2 = in.ni() - 1;
      boolean can = rowIndex[row1] == rowIndex[row2] && colIndex[col1] == colIndex[col2];
      out.println(can ? "YES" : "NO");
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
    try (EvenPath instance = new EvenPath()) {
      instance.solve();
    }
  }
}
