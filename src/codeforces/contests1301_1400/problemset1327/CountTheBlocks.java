package codeforces.contests1301_1400.problemset1327;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountTheBlocks implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    final long MOD = 998244353;
    long[] result = new long[n + 5];
    result[1] = 10;
    result[2] = 180;
    result[3] = 2610;

    long[] ten = new long[n + 1];
    ten[0] = 1;
    for (int i = 1; i <= n; i++) {
      ten[i] = ten[i - 1] * 10;
      ten[i] %= MOD;
    }
    for (int i = 4; i <= n; i++) {
      result[i] = (ten[i - 2] * 180) % MOD;
      result[i] += ten[i - 3] * (i - 2L) * 810;
      result[i] %= MOD;
    }
    for (int i = n; i >= 1; i--) {
      out.print(result[i]);
      out.print(' ');
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
    try (CountTheBlocks instance = new CountTheBlocks()) {
      instance.solve();
    }
  }
}
