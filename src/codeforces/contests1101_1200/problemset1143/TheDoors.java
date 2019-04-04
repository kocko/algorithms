package codeforces.contests1101_1200.problemset1143;

import java.io.*;
import java.util.StringTokenizer;

public class TheDoors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), zeroes = 0, ones = 0;
    int[] x = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      x[i] = in.ni();
      if (x[i] == 0) zeroes++;
      else ones++;
    }
    for (int i = 1; i <= n; i++) {
      if (x[i] == 0) zeroes--;
      else ones--;
      if (zeroes == 0 || ones == 0) {
        out.println(i);
        break;
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
    try (TheDoors instance = new TheDoors()) {
      instance.solve();
    }
  }
}
