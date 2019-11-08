package codeforces.contests301_400.problemset330;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Purification implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    boolean[][] grid = new boolean[n][n];
    boolean[] row = new boolean[n], col = new boolean[n];
    for (int i = 0; i < n; i++) {
      char[] x = in.next().toCharArray();
      for (int j = 0; j < n; j++) {
        if (x[j] == '.') {
          row[i] = true;
          col[j] = true;
        } else {
          grid[i][j] = true;
        }
      }
    }
    boolean r = true, c = true;
    for (int i = 0; i < n; i++) {
      if (!row[i]) {
        r = false;
      }
      if (!col[i]) {
        c = false;
      }
    }
    if (!r && !c) {
      out.println(-1);
      return;
    }

    if (r) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!grid[i][j]) {
            out.println((i + 1) + " " + (j + 1));
            break;
          }
        }
      }
    } else {
      for (int j = 0; j < n; j++) {
        for (int i = 0; i < n; i++) {
          if (!grid[i][j]) {
            out.println((i + 1) + " " + (j + 1));
            break;
          }
        }
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
    try (Purification instance = new Purification()) {
      instance.solve();
    }
  }
}
