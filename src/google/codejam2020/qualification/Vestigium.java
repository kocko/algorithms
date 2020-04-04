package google.codejam2020.qualification;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Vestigium implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      n = in.ni();
      int[][] x = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          x[i][j] = in.ni();
        }
      }
      out.printf("Case #%d: %d %d %d\n", testCase, trace(x), badRows(x), badColumns(x));
    }
  }

  private int n;

  private int trace(int[][] x) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      result += x[i][i];
    }
    return result;
  }

  private int badRows(int[][] x) {
    int result = 0;
    for (int row = 0; row < n; row++) {
      int[] cnt = new int[101];
      boolean bad = false;
      for (int col = 0; col < n; col++) {
        cnt[x[row][col]]++;
        if (cnt[x[row][col]] > 1) {
          bad = true;
        }
      }
      if (bad) {
        result++;
      }
    }
    return result;
  }

  private int badColumns(int[][] x) {
    int result = 0;
    for (int col = 0; col < n; col++) {
      int[] cnt = new int[101];
      boolean bad = false;
      for (int row = 0; row < n; row++) {
        cnt[x[row][col]]++;
        if (cnt[x[row][col]] > 1) {
          bad = true;
        }
      }
      if (bad) {
        result++;
      }
    }
    return result;
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
    try (Vestigium instance = new Vestigium()) {
      instance.solve();
    }
  }
}
