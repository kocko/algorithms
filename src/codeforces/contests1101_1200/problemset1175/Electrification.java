package codeforces.contests1101_1200.problemset1175;

import java.io.*;
import java.util.StringTokenizer;

public class Electrification implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      int min = Integer.MAX_VALUE;
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      int x_;
      if (k == 0) {
        x_ = x[0];
      } else {
        int point = 0;
        for (int i = 0; i < n - k; i++) {
          int score = (x[i + k] - x[i]);
          if (score < min) {
            min = score;
            point = i;
          }
        }
        x_ = (x[point] + x[point + k]) / 2;
      }
      out.println(x_);
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
    try (Electrification instance = new Electrification()) {
      instance.solve();
    }
  }
}
