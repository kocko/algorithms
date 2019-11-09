package codeforces.contests101_200.problemset182;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CommonDivisors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    char[] y = in.next().toCharArray();
    int px = period(x), py = period(y), result = 0;
    for (int len = 0; len < x.length && len < y.length && x[len] == y[len];) {
      len++;
      if (len % px == 0 && len % py == 0 && x.length % len == 0 && y.length % len == 0) {
        result++;
      }
    }
    out.println(result);
  }

  private int[] prefix(char[] x) {
    int n = x.length;
    int[] p = new int[n];
    int k = 0;
    for (int i = 1; i < n; i++) {
      p[i] = p[i - 1];
      while (k > 0 && x[i] != x[k]) {
        k = p[k - 1];
      }
      if (x[i] == x[k]) {
        k++;
      }
      p[i] = k;
    }
    return p;
  }

  private int period(char[] s) {
    int n = s.length;
    int ret = n - prefix(s)[n - 1];
    return (n % ret != 0) ? n : ret;
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
    try (CommonDivisors instance = new CommonDivisors()) {
      instance.solve();
    }
  }
}
