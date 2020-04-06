package codeforces.contests1201_1300.problemset1295;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InfinitePrefixes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), x = in.ni();
      char[] s = in.next().toCharArray();
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        int delta = s[i] == '0' ? 1 : -1;
        b[i] = delta;
        if (i >= 1) {
          b[i] += b[i - 1];
        }
      }
      int result = 0;
      if (x == 0) {
        result++;
      }
      boolean infinite = false;
      int delta = b[n - 1];
      if (delta == 0) {
        for (int i = 0; i < n; i++) {
          if (b[i] == x) {
            infinite = true;
          }
        }
      } else {
        for (int i = 0; i < n; i++) {
          int balance = b[i], need = x - balance;
          if (need < 0 && delta > 0) continue;
          if (need > 0 && delta < 0) continue;
          if (need % delta == 0) {
            result++;
          }
        }
      }
      if (infinite) {
        result = -1;
      }
      out.println(result);
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
    try (InfinitePrefixes instance = new InfinitePrefixes()) {
      instance.solve();
    }
  }
}
