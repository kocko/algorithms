package codeforces.contests1301_1400.problemset1385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class AGoodString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      x = in.next().toCharArray();
      out.println(recurse(0, n, 'a'));
    }
  }

  private char[] x;

  private int recurse(int left, int right, char target) {
    if (left == right - 1) return x[left] == target ? 0 : 1;

    int mid = (left + right) / 2;
    int c1 = 0;
    for (int i = left; i < mid; i++) {
      if (x[i] != target) {
        c1++;
      }
    }
    int c2 = 0;
    for (int i = mid; i < right; i++) {
      if (x[i] != target) {
        c2++;
      }
    }
    char next = (char) (target + 1);
    return min(c2 + recurse(left, mid, next), c1 + recurse(mid, right, next));
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
    try (AGoodString instance = new AGoodString()) {
      instance.solve();
    }
  }
}
