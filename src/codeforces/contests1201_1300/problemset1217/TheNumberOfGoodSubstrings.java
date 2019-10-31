package codeforces.contests1201_1300.problemset1217;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheNumberOfGoodSubstrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int result = 0, n = x.length, lastOne = -1;
      for (int start = 0; start < n; start++) {
        long value = 0;
        if (x[start] == '1') {
          for (int end = start; end <= Math.min(n - 1, start + 18); end++) {
            value <<= 1;
            value += (x[end] - '0');
            int size = end - start + 1;
            int dist = start - lastOne - 1;
            if (value > size) {
              if (size + dist >= value) {
                result++;
              }
            } else if (value == size) {
              result++;
            }
          }
          lastOne = start;
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
    try (TheNumberOfGoodSubstrings instance = new TheNumberOfGoodSubstrings()) {
      instance.solve();
    }
  }
}
