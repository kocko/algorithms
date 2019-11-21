package codeforces.contests1201_1300.problemset1253;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SinglePush implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n], b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      int[] c = new int[n];
      int k = 0;
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
        c[i] = b[i] - a[i];
        if (c[i] != 0) {
          k = c[i];
        }
      }
      boolean ok = k >= 0;
      int first = -1, last = -1;
      for (int i = 0; i < n; i++) {
        if (c[i] == k) {
          if (first == -1) {
            first = last = i;
          } else {
            last = i;
          }
        } else if (c[i] != 0 && c[i] != k) {
          ok = false;
          break;
        }
      }
      if (first >= 0) {
        for (int i = first; i <= last; i++) {
          ok &= c[i] == k;
        }
      } else {
        ok = false;
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
    try (SinglePush instance = new SinglePush()) {
      instance.solve();
    }
  }
}
