package codeforces.contests201_300.problemset257;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ViewAngle implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    double[] tang = new double[n];
    for (int i = 0; i < n; i++) {
      int x = in.ni(), y = in.ni();
      tang[i] = Math.atan2(y, x);
    }
    Arrays.sort(tang);
    double result = 0;
    for (int i = 0; i < n; i++) {
      double next = Math.abs(tang[i] - tang[(i + 1) % n]);
      if (i == n - 1) {
        next = 2 * Math.PI - next;
      }
      result = Math.max(result, next);
    }
    out.println(360 - result * 360 / (2 * Math.PI));
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
    try (ViewAngle instance = new ViewAngle()) {
      instance.solve();
    }
  }
}
