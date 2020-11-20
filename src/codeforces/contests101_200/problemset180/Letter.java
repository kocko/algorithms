package codeforces.contests101_200.problemset180;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Letter implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    int[] lower = new int[n], upper = new int[n];
    for (int i = 0; i < n; i++) {
      if (x[i] >= 'a' && x[i] <= 'z') {
        lower[i]++;
      }
      if (i > 0) {
        lower[i] += lower[i - 1];
      }
    }
    for (int i = n - 1; i >= 0; i--) {
      if (x[i] >= 'A' && x[i] <= 'Z') {
        upper[i]++;
      }
      if (i < n - 1) {
        upper[i] += upper[i + 1];
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      result = Math.min(lower[i] + upper[i + 1], result);
    }
    result = Math.min(result, upper[0]);
    result = Math.min(result, lower[n - 1]);
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
    try (Letter instance = new Letter()) {
      instance.solve();
    }
  }
}
