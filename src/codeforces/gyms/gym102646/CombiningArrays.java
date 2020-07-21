package codeforces.gyms.gym102646;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CombiningArrays implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) a[i] = in.ni();
    for (int i = 0; i < n; i++) b[i] = in.ni();
    int i = 0, j = 0;
    while (i < n || j < n) {
      int x = i < n ? a[i] : Integer.MAX_VALUE;
      int y = j < n ? b[j] : Integer.MAX_VALUE;
      if (x < y) {
        out.print(x);
        i++;
      } else {
        out.print(y);
        j++;
      }
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
    try (CombiningArrays instance = new CombiningArrays()) {
      instance.solve();
    }
  }
}
