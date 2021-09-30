package atcoder.beginner.contest220;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongSequence implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public LongSequence() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    long sum = 0;
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
      sum += a[i];
    }
    long X = in.nl() + 1;
    long result = (X / sum) * n;
    if (X % sum != 0) {
      X %= sum;
      long prefix = 0;
      for (int i = 0; i < n && prefix < X; i++) {
        prefix += a[i];
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
    try (LongSequence instance = new LongSequence()) {
      instance.solve();
    }
  }
}
