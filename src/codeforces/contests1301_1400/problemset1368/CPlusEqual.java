package codeforces.contests1301_1400.problemset1368;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CPlusEqual implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    List<Integer> fib = new ArrayList<>();
    int p = 1, q = 1;
    fib.add(p);
    fib.add(q);
    while (q < 1000000000) {
      int next = p + q;
      p = q;
      q = next;
      fib.add(next);
    }
    int T = in.ni();
    while (T-- > 0) {
      int a = in.ni(), b = in.ni(), n = in.ni();
      int result = 100;
      for (int i = 1; i < fib.size(); i++) {
        if (fib.get(i) * a + fib.get(i - 1) * b > n) {
          result = Math.min(result, i);
          break;
        }
      }
      for (int i = 1; i < fib.size(); i++) {
        if (fib.get(i) * b + fib.get(i - 1) * a > n) {
          result = Math.min(result, i);
          break;
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
    try (CPlusEqual instance = new CPlusEqual()) {
      instance.solve();
    }
  }
}
