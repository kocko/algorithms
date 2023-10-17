package codeforces.contests1201_1300.problemset1272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class ThreeFriends implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ThreeFriends() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      long a = in.nl(), b = in.nl(), c = in.nl();
      long result = Long.MAX_VALUE;
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          for (int k = -1; k <= 1; k++) {
            long a_ = a + i, b_ = b + j, c_ = c + k;
            result = min(result, abs(a_ - c_) + abs(a_ - b_) + abs(b_ - c_));
          }
        }
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
    try (ThreeFriends instance = new ThreeFriends()) {
      instance.solve();
    }
  }
}
