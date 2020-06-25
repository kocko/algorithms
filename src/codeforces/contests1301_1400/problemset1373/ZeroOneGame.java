package codeforces.contests1301_1400.problemset1373;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZeroOneGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int pairs = 0, ones = 0, zeroes = 0;
      for (char c : x) {
        if (c == '1') {
          if (zeroes > 0) {
            pairs++;
            zeroes--;
          } else {
            ones++;
          }
        } else {
          if (ones > 0) {
            pairs++;
            ones--;
          } else {
            zeroes++;
          }
        }
      }
      out.println(pairs % 2 == 1 ? "DA" : "NET");
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
    try (ZeroOneGame instance = new ZeroOneGame()) {
      instance.solve();
    }
  }
}
