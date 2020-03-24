package codeforces.contests1301_1400.problemset1315;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Homecoming implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int a = in.ni(), b = in.ni(), p = in.ni();
      char[] x = in.next().toCharArray();
      int n = x.length;
      int[] price = new int[n];
      char last = '?';
      int spent = 0, idx;
      for (idx = n - 2; idx >= 0; idx--) {
        char ch = x[idx];
        if (ch != last) {
          last = ch;
          spent += last == 'A' ? a : b;
        }
        if (spent > p) break;
        price[idx] = last == 'A' ? a : b;
      }
      out.println(idx + 2);
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
    try (Homecoming instance = new Homecoming()) {
      instance.solve();
    }
  }
}
