package codeforces.contests1301_1400.problemset1343;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlternatingSubsequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      long ans = 0;
      final int POS = 0, NEG = 1;
      int sign = x[0] > 0 ? 0 : 1;
      long currentMax = x[0];
      for (int i = 1; i < n; i++) {
        long value = x[i];
        int s = value > 0 ? POS : NEG;
        if (s == sign) {
          currentMax = Math.max(currentMax, value);
        } else {
          ans += currentMax;
          currentMax = x[i];
          sign ^= 1;
        }
      }

      ans += currentMax;
      out.println(ans);
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
    try (AlternatingSubsequence instance = new AlternatingSubsequence()) {
      instance.solve();
    }
  }
}
