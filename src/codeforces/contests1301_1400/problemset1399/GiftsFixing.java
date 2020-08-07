package codeforces.contests1301_1400.problemset1399;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GiftsFixing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] oranges = new long[n];
      long[] candies = new long[n];
      long minOrange = Long.MAX_VALUE, minCandy = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        oranges[i] = in.ni();
        minOrange = Math.min(minOrange, oranges[i]);
      }
      for (int i = 0; i < n; i++) {
        candies[i] = in.ni();
        minCandy = Math.min(minCandy, candies[i]);
      }
      long result = 0;
      for (int i = 0; i < n; i++) {
        long pair = Math.min(oranges[i] - minOrange, candies[i] - minCandy);
        result += pair;
        oranges[i] -= pair;
        candies[i] -= pair;
        result += oranges[i] - minOrange;
        result += candies[i] - minCandy;
      }
      out.println(result);
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
    try (GiftsFixing instance = new GiftsFixing()) {
      instance.solve();
    }
  }
}
