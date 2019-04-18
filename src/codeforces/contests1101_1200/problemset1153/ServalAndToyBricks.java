package codeforces.contests1101_1200.problemset1153;

import java.io.*;
import java.util.StringTokenizer;

public class ServalAndToyBricks implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), h = in.ni();
    int[] front = new int[m];
    for (int i = 0; i < m; i++) {
      front[i] = in.ni();
    }
    int[] left = new int[n];
    for (int i = 0; i < n; i++) {
      left[i] = in.ni();
    }
    int[][] top = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        top[i][j] = in.ni();
      }
    }
    int[][] result = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (top[i][j] == 1) {
          result[i][j] = Math.min(left[i], front[j]);
          out.print(result[i][j]);
        } else {
          out.print(0);
        }
        out.print(' ');
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
    try (ServalAndToyBricks instance = new ServalAndToyBricks()) {
      instance.solve();
    }
  }
}
