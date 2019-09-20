package codeforces.contests1201_1300.problemset1207;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SquareFilling implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n =  in.ni(), m = in.ni();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.ni();
      }
    }
    List<int[]> result = new ArrayList<>();
    int[][] b = new int[n][m];
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m - 1; j++) {
        if (a[i][j] == 1 && a[i + 1][j] == 1 && a[i][j + 1] == 1 && a[i + 1][j + 1] == 1) {
          result.add(new int[]{i, j});
          b[i][j] = b[i][j + 1] = b[i + 1][j] = b[i + 1][j + 1] = 1;
        }
      }
    }
    boolean same = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        same &= a[i][j] == b[i][j];
      }
    }
    if (same) {
      out.println(result.size());
      for (int[] pair : result) {
        out.println((pair[0] + 1) + " " + (pair[1] + 1));
      }
    } else {
      out.println("-1");
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
    try (SquareFilling instance = new SquareFilling()) {
      instance.solve();
    }
  }
}
