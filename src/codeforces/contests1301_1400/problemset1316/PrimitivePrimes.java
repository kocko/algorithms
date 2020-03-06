package codeforces.contests1301_1400.problemset1316;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrimitivePrimes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), p = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.ni();
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] % p != 0) {
        result += i;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (b[i] % p != 0) {
        result += i;
        break;
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
    try (PrimitivePrimes instance = new PrimitivePrimes()) {
      instance.solve();
    }
  }
}
