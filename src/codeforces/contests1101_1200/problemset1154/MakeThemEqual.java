package codeforces.contests1101_1200.problemset1154;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeThemEqual implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    Arrays.sort(x);
    int d = (x[n - 1] - x[0]) % 2 == 0 ? (x[n - 1] - x[0]) / 2 : (x[n - 1] - x[0]);
    for (int i = 1; i < n - 1; i++) {
      if (!(x[i] == x[0] || x[i] == x[n - 1] || x[i] == x[0] + d || x[i] == x[n - 1] - d)) {
        out.println(-1);
        return;
      }
    }
    out.println(d);
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
    try (MakeThemEqual instance = new MakeThemEqual()) {
      instance.solve();
    }
  }
}
