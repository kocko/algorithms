package codeforces.contests1101_1200.problemset1194;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YetAnotherCrossesProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] x = new char[n][m];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      int[] row = new int[n], col = new int[m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (x[i][j] == '*') {
            row[i]++;
            col[j]++;
          }
        }
      }
      int ans = n + m + 5;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int need = n - row[i] + m - col[j];
          if (x[i][j] == '.') {
            need--;
          }
          ans = Math.min(ans, need);
        }
      }
      out.println(ans);
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
    try (YetAnotherCrossesProblem instance = new YetAnotherCrossesProblem()) {
      instance.solve();
    }
  }
}
