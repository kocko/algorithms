package google.codejam2020.qualification;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NestingDepth implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      char[] x = in.next().toCharArray();
      out.printf("Case #%d: %s\n", testCase, solve(x));
    }
  }

  private String solve(char[] x) {
    int current = 0;
    StringBuilder sb = new StringBuilder();
    for (char c : x) {
      int value = c - '0';
      if (value > current) {
        int open = value - current;
        while (open-- > 0) {
          sb.append('(');
          current++;
        }
      } else if (value < current) {
        int close = current - value;
        while (close-- > 0) {
          sb.append(')');
          current--;
        }
      }
      sb.append(value);
    }
    while (current > 0) {
      sb.append(')');
      current--;
    }
    return sb.toString();
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
    try (NestingDepth instance = new NestingDepth()) {
      instance.solve();
    }
  }
}
