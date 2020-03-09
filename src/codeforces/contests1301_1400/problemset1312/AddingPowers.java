package codeforces.contests1301_1400.problemset1312;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddingPowers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long k = in.nl();
      long[] power = new long[31];
      long current = 1L;
      final long MAX_N = (long) 1e16;
      for (int i = 0; current > 0 && current <= MAX_N && i <= 30; i++) {
        power[i] = current;
        current *= k;
      }
      boolean ok = true;
      for (int i = 0; i < n; i++) {
        long next = in.nl();
        if (next > 0) {
          for (int j = 30; j >= 0; j--) {
            if (power[j] > 0 && next > 0 && next >= power[j]) {
              next -= power[j];
              power[j] = 0;
            }
          }
        }
        ok &= next == 0;
      }
      out.println(ok ? "YES" : "NO");
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
    try (AddingPowers instance = new AddingPowers()) {
      instance.solve();
    }
  }
}
