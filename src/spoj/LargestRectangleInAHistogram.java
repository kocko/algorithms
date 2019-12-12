package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class LargestRectangleInAHistogram implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n;
    while ((n = in.ni()) != 0) {
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      ArrayDeque<Integer> stack = new ArrayDeque<>();
      long[] result = new long[n];
      for (int i = n - 1; i >= 0; i--) {
        while (stack.size() > 0) {
          int idx = stack.peekLast();
          if (x[idx] >= x[i]) {
            stack.pollLast();
          } else break;
        }
        int idx = n;
        if (stack.size() > 0) {
          idx = stack.peekLast();
        }
        stack.addLast(i);
        result[i] = x[i] * (idx - i);
      }
      stack = new ArrayDeque<>();
      long max = 0;
      for (int i = 0; i < n; i++) {
        while (stack.size() > 0) {
          int idx = stack.peekLast();
          if (x[idx] >= x[i]) {
            stack.pollLast();
          } else break;
        }
        int idx = -1;
        if (stack.size() > 0) {
          idx = stack.peekLast();
        }
        stack.addLast(i);
        long area = x[i] * (i - idx);
        result[i] = result[i] + area - x[i];
        max = Math.max(result[i], max);
      }
      out.println(max);
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
    try (LargestRectangleInAHistogram instance = new LargestRectangleInAHistogram()) {
      instance.solve();
    }
  }
}
