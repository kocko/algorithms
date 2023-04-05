package codeforces.contests1801_1900.problemset1811;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RestoreTheArray implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public RestoreTheArray() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] b = new int[n - 1];
      for (int i = 0; i < n - 1; i++) {
        b[i] = in.ni();
      }
      int[] a = new int[n];
      a[0] = b[0];
      for (int i = 1; i < n - 1; i++) {
        a[i] = Math.min(b[i], b[i - 1]);
      }
      a[n - 1] = b[n - 2];
      for (int i = 0; i < n; i++) {
        out.print(a[i]);
        out.print(' ');
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
    try (RestoreTheArray instance = new RestoreTheArray()) {
      instance.solve();
    }
  }
}
