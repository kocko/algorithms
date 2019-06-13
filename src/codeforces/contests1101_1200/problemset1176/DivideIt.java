package codeforces.contests1101_1200.problemset1176;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DivideIt implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      out.println(divide(in.nl()));
    }
  }
  
  private int divide(long x) {
    int moves = 0;
    while (x % 5 == 0) {
      moves++;
      x /= 5;
      x <<= 2;
    }
    while (x % 3 == 0) {
      moves++;
      x /= 3;
      x <<= 1;
    }
    while (x % 2 == 0) {
      moves++;
      x >>= 1;
    }
    return x == 1 ? moves : -1;
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
    try (DivideIt instance = new DivideIt()) {
      instance.solve();
    }
  }
}
