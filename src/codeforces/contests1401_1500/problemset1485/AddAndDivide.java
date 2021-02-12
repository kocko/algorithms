package codeforces.contests1401_1500.problemset1485;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddAndDivide implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long a = in.nl(), b = in.nl(), result = Integer.MAX_VALUE;
      if (b > 1) {
        long x = a;
        long score = 0;
        while (x > 0) {
          x /= b;
          score++;
        }
        if (score < result) {
          result = score;
        }
      }
      for (int i = 1; ; i++) {
        long x = a, tmp = b + i;
        long score = i;
        while (x > 0) {
          x /= tmp;
          score++;
        }
        if (score <= result) {
          result = score;
        } else break;
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
    try (AddAndDivide instance = new AddAndDivide()) {
      instance.solve();
    }
  }
}
