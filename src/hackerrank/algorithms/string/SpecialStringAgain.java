package hackerrank.algorithms.string;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpecialStringAgain implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SpecialStringAgain() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    long result = 0;
    int current = 1;
    for (int idx = 1; idx < n; idx++) {
      if (x[idx] == x[idx - 1]) {
        current++;
      } else {
        result += ((1L + current) * current) >> 1;
        current = 1;
      }
    }
    result += ((1L + current) * current) >> 1;
    for (int idx = 1; idx < n - 1;) {
      current = 0;
      int left = idx - 1, right = idx + 1;
      while (left >= 0 && right < n && x[left] == x[right] && x[left] != x[idx] && x[left] == x[idx - 1]) {
        current++;
        left--;
        right++;
      }
      result += current;
      if (current != 0) {
        idx = right - 1;
      } else {
        idx = right;
      }
    }

    out.println(result);
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
    try (SpecialStringAgain instance = new SpecialStringAgain()) {
      instance.solve();
    }
  }
}
