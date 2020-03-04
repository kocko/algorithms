package codeforces.contests1301_1400.problemset1311;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeirdSort implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[] a = new int[n];
      boolean[] can = new boolean[101];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      for (int i = 0; i < m; i++) {
        can[in.ni() - 1] = true;
      }
      for (int i = 1; i < n; i++) {
        int idx = i;
        while (idx > 0 && a[idx] < a[idx - 1] && can[idx - 1]) {
          swap(a, idx, idx - 1);
          idx--;
        }
      }
      boolean ok = true;
      for (int i = 0; i < n - 1; i++) {
        ok &= a[i] <= a[i + 1];
      }
      out.println(ok ? "YES" : "NO");
    }
  }

  private void swap(int[] x, int p, int q) {
    x[p] = x[q] ^ x[p] ^ (x[q] = x[p]);
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
    try (WeirdSort instance = new WeirdSort()) {
      instance.solve();
    }
  }
}
