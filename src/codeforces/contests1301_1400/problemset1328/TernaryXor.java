package codeforces.contests1301_1400.problemset1328;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TernaryXor implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] xor = in.next().toCharArray();
      char[] a = new char[n], b = new char[n];
      boolean same = true;
      for (int i = 0; i < n; i++) {
        int value = xor[i] - '0';
        if (value == 0) {
          a[i] = b[i] = '0';
        } else if (value == 1) {
          if (same) {
            a[i] = '1';
            b[i] = '0';
            same = false;
          } else {
            a[i] = '0';
            b[i] = '1';
          }
        } else {
          if (same) {
            a[i] = b[i] = '1';
          } else {
            a[i] = '0';
            b[i] = '2';
          }
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(a[i]);
      }
      out.println();
      for (int i = 0; i < n; i++) {
        out.print(b[i]);
      }
      out.println();
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
    try (TernaryXor instance = new TernaryXor()) {
      instance.solve();
    }
  }
}
