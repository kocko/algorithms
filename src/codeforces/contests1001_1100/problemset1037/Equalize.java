package codeforces.contests1001_1100.problemset1037;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Equalize implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray(), y = in.next().toCharArray();
    boolean[] different = new boolean[n];
    for (int i = 0; i < n; i++) {
      different[i] = (x[i] != y[i]);
    }
    long result = 0;
    for (int i = 1; i < n; i++) {
      if (different[i] && different[i - 1]) {

        if ((x[i] == '1' && y[i] == '0' && x[i - 1] == '0' && y[i - 1] == '1') ||
            (x[i] == '0' && y[i] == '1' && x[i - 1] == '1' && y[i - 1] == '0')) {
          different[i] = different[i - 1] = false;
          result++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (different[i]) {
        result++;
      }
    }
    out.println(result);
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
    try (Equalize instance = new Equalize()) {
      instance.solve();
    }
  }
}
