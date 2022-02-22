package codeforces.contests1601_1700.problemset1644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AntiFibonacciPermutation implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public AntiFibonacciPermutation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] perm = new int[n];
      for (int i = n - 1; i >= 0; i--) {
        perm[n - i - 1] = i + 1;
      }
      int idx = n - 1;
      do {
        print(perm);
        if (idx > 0) {
          perm[idx] = perm[idx - 1] ^ perm[idx] ^ (perm[idx - 1] = perm[idx]);
        }
      } while (--idx >= 0);
    }
  }

  private void print(int[] x) {
    for (int i = 0; i < x.length; i++) {
      out.print(x[i]);
      out.print(' ');
    }
    out.println();
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
    try (AntiFibonacciPermutation instance = new AntiFibonacciPermutation()) {
      instance.solve();
    }
  }
}
