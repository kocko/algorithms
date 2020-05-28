package codeforces.contests1301_1400.problemset1359;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewTheatreSquare implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), x = in.ni(), y = in.ni();
      int result = 0;
      for (int i = 0; i < n; i++) {
        char[] row = in.next().toCharArray();
        int current = 0;
        for (int j = 0; j < m; j++) {
          if (row[j] == '.') {
            current++;
          } else {
            if (2 * x <= y) {
              result += (current * x);
            } else {
              int big = current / 2;
              result += big * y;
              if (current % 2 == 1) {
                result += x;
              }
            }
            current = 0;
          }
        }
        if (2 * x <= y) {
          result += (current * x);
        } else {
          int big = current / 2;
          result += big * y;
          if (current % 2 == 1) {
            result += x;
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
    try (NewTheatreSquare instance = new NewTheatreSquare()) {
      instance.solve();
    }
  }
}
