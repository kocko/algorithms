package atcoder.beginner.contest125;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class GCDOnBlackboard implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GCDOnBlackboard() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    int[] x = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      x[i] = in.ni();
    }
    int[] prefix = new int[n + 2];
    int[] suffix = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      prefix[i] = gcd(prefix[i - 1], x[i]);
      suffix[n - i + 1] = gcd(suffix[n - i + 2], x[n - i + 1]);
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      result = Math.max(gcd(prefix[i - 1], suffix[i + 1]), result);
    }
    out.println(result);
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (GCDOnBlackboard instance = new GCDOnBlackboard()) {
      instance.solve();
    }
  }
}
