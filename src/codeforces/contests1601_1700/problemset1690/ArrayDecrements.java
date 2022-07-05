package codeforces.contests1601_1700.problemset1690;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ArrayDecrements implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
      }
      int moves = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (b[i] != 0) {
          moves = a[i] - b[i];
          break;
        }
      }
      boolean ok = true;
      for (int i = 0; i < n; i++) {
        if (a[i] >= b[i]) {
          if (b[i] != 0) {
            ok &= a[i] - b[i] == moves;
          } else {
            ok &= a[i] - b[i] <= moves;
          }
        } else {
          ok = false;
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
    try (ArrayDecrements instance = new ArrayDecrements()) {
      instance.solve();
    }
  }
}
