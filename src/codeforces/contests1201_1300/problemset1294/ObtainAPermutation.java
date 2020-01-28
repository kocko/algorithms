package codeforces.contests1201_1300.problemset1294;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ObtainAPermutation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    int[][] x = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        x[i][j] = in.ni();
      }
    }
    int result = 0;
    for (int col = 0; col < m; col++) {
      int[] values = new int[n];
      for (int i = 0; i < n; i++) {
        values[i] = x[i][col];
      }
      result += solve(values, col);
    }
    out.println(result);
  }

  private int n, m;

  private int solve(int[] values, int col) {
    int[] x = new int[2 * n];
    int[] score = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = x[i + n] = values[i];
      score[i] = n;
    }
    for (int i = 0; i < 2 * n; i++) {
      if (x[i] - col - 1 >= 0 && (x[i] - col - 1) % m == 0) {
        int start = (x[i] - col - 1) / m;
        if (start < n && i - start >= 0 && i - start < n) {
          score[i - start]--;
        }
      }
    }
    int result = Integer.MAX_VALUE;
    for (int shift = 0; shift < n; shift++) {
      result = Math.min(result, shift + score[shift]);
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
    try (ObtainAPermutation instance = new ObtainAPermutation()) {
      instance.solve();
    }
  }
}
