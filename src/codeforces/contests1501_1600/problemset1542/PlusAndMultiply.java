package codeforces.contests1501_1600.problemset1542;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PlusAndMultiply implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PlusAndMultiply() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl(), a = in.nl(), b = in.nl();
      if (a == 1) {
        n--;
        out.println(n % b == 0 ? "Yes" : "No");
      } else if (b == 1) {
        out.println("Yes");
      } else {
        boolean possible = false;
        long x = 1L;
        while (n >= x) {
          if ((n - x) % b == 0) {
            possible = true;
          }
          x *= a;
        }
        out.println(possible ? "Yes" : "No");
      }
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
    try (PlusAndMultiply instance = new PlusAndMultiply()) {
      instance.solve();
    }
  }
}
