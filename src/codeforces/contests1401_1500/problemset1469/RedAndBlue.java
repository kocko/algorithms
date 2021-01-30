package codeforces.contests1401_1500.problemset1469;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RedAndBlue implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] red = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        red[i] = in.ni();
        red[i] += red[i - 1];
      }
      int m = in.ni();
      int[] blue = new int[m + 1];
      for (int i = 1; i <= m; i++) {
        blue[i] = in.ni();
        blue[i] += blue[i - 1];
      }
      int max = 0;
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          max = Math.max(red[i] + blue[j], max);
        }
      }
      out.println(max);
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
    try (RedAndBlue instance = new RedAndBlue()) {
      instance.solve();
    }
  }
}
