package codeforces.contests1101_1200.problemset1175;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class CatchOverflow implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long result = 0;
    Stack<Long> stack = new Stack<>();
    stack.add(1L);
    while (n-- > 0) {
      String command = in.next();
      if ("add".equals(command)) {
        result = add(result, stack.peek());
      } else if ("for".equals(command)) {
        stack.push(multiply(stack.peek(), in.ni()));
      } else {
        stack.pop();
      }
    }
    out.println(result == oo ? "OVERFLOW!!!" : result);
  }
  
  private final long oo = 1L << 32;
  
  private long add(long a, long b) {
    return a + b >= oo ? oo : a + b;
  }
  
  private long multiply(long a, long b) {
    return a >= (oo + b - 1) * b ? oo : a * b;
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
    try (CatchOverflow instance = new CatchOverflow()) {
      instance.solve();
    }
  }
}
