package codeforces.contests1301_1400.problemset1368;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AndOrAndSquareSum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] x = new long[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    long[] result = new long[n];
    for (int i = 0; i < 20; i++) {
      int count = 0;
      long bit = 1L << i;
      for (int j = 0; j < n; j++) {
        if ((x[j] & bit) != 0) {
          count++;
        }
      }
      for (int row = 0; row < count; row++) {
        result[row] |= bit;
      }
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += (result[i] * result[i]);
    }
    out.println(ans);
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
    try (AndOrAndSquareSum instance = new AndOrAndSquareSum()) {
      instance.solve();
    }
  }
}
