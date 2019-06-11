package codeforces.contests1101_1200.problemset1182;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PlusFromPicture implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] x = new char[n][m];
    for (int i = 0; i < n; i++) {
      x[i] = in.next().toCharArray();
    }
    boolean[][] center = new boolean[n][m];
    int centers = 0;
    int p = -1, q = -1;
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        if (x[i][j] == '*' && x[i - 1][j] == '*' && x[i + 1][j] == '*' && x[i][j - 1] == '*' && x[i][j + 1] == '*') {
          center[i][j] = true;
          centers++;
          p = i;
          q = j;
        }
      }
    }
    if (centers == 1) {
      for (int row = p; row >= 0 && x[row][q] == '*'; row--) {
        x[row][q] = '.';
      }
      for (int row = p + 1; row <  n && x[row][q] == '*'; row++) {
        x[row][q] = '.';
      }
      for (int col = q + 1; col < m  && x[p][col] == '*'; col++) {
        x[p][col] = '.';
      }
      for (int col = q - 1; col >= 0 && x[p][col] == '*'; col--) {
        x[p][col] = '.';
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (x[i][j] == '*') {
            out.println("NO");
            return;
          }
        }
      }
      out.println("YES");
    } else {
      out.println("NO");
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
    try (PlusFromPicture instance = new PlusFromPicture()) {
      instance.solve();
    }
  }
}