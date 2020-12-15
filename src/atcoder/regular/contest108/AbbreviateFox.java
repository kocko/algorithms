package atcoder.regular.contest108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class AbbreviateFox implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char c : x) {
      stack.addLast(c);
      if (stack.size() >= 3) {
        char p = stack.pollLast(), q = stack.pollLast(), r = stack.pollLast();
        if (!(p == 'x' && q == 'o' && r == 'f')) {
          stack.addLast(r);
          stack.addLast(q);
          stack.addLast(p);
        }
      }
    }
    out.println(stack.size());
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
    try (AbbreviateFox instance = new AbbreviateFox()) {
      instance.solve();
    }
  }
}
