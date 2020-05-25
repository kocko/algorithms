package codeforces.contests1301_1400.problemset1360;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Polygon implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[][] x = new char[n][n];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      boolean ok = true;
      for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
          if (x[i][j] == '1') {
            char right = j == n - 1 ? '1' : x[i][j + 1];
            char down = i == n - 1 ? '1' : x[i + 1][j];
            ok &= (right == '1' || down == '1');
          }
        }
      }
      out.println(ok ? "YES" : "NO");
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
    try (Polygon instance = new Polygon()) {
      instance.solve();
    }
  }
}
