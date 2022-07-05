package codeforces.contests1601_1700.problemset1699;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class AlmostTernaryMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] result = new int[n][m];
      for (int i = 0; i < n - 1; i += 2) {
        int[] prev;
        if (i % 4 == 0) {
          prev = new int[]{0, 1};
        } else {
          prev = new int[]{1, 0};
        }
        for (int j = 0; j < m - 1; j += 2) {
          result[i][j] = result[i + 1][j + 1] = prev[0];
          result[i][j + 1] = result[i + 1][j] = prev[1];
          prev[0] ^= 1;
          prev[1] ^= 1;
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          out.print(result[i][j]);
          out.print(' ');
        }
        out.println();
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
    try (AlmostTernaryMatrix instance = new AlmostTernaryMatrix()) {
      instance.solve();
    }
  }
}