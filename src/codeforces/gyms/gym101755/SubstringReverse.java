package codeforces.gyms.gym101755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SubstringReverse implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray(), y = in.next().toCharArray();
    boolean ok = x.length == y.length;
    if (ok) {
      int left = -1, n = x.length;
      for (int i = 0; i < n; i++) {
        if (x[i] != y[i]) {
          left = i;
          break;
        }
      }
      int right = n;
      for (int i = n - 1; i >= Math.max(0, left); i--) {
        if (x[i] != y[i]) {
          right = i;
          break;
        }
      }
      if (left >= 0 && right < n) {
        for (int i = 0; i <= right - left; i++) {
          ok &= x[left + i] == y[right - i];
        }
      }
    }
    out.println(ok ? "YES" : "NO");
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
    try (SubstringReverse instance = new SubstringReverse()) {
      instance.solve();
    }
  }
}
