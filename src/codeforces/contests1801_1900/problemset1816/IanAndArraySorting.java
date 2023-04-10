package codeforces.contests1801_1900.problemset1816;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IanAndArraySorting implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public IanAndArraySorting() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      if (n % 2 == 1) {
        out.println("YES");
        continue;
      }
      boolean ok = true;
      int prev = 0;
      for (int i = 1; i < n; i += 2) {
        x[i] += prev;
        if (x[i] < x[i - 1] && i == n - 1) {
          ok = false;
        }
        long diff = x[i - 1] - x[i];
        x[i] += diff;
        if (i + 1 < n) {
          x[i + 1] += diff;
        }
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
    try (IanAndArraySorting instance = new IanAndArraySorting()) {
      instance.solve();
    }
  }
}
