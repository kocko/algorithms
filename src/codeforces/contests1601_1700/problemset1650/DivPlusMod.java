package codeforces.contests1601_1700.problemset1650;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class DivPlusMod implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public DivPlusMod() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int left = in.ni(), right = in.ni(), a = in.ni();
      int result = f(right, a);
      if (right - left + 1 >= a) {
        result = max(result, f(max(left, right - right % a - 1), a));
      } else {
        int diff = left % a;
        if (left + (a - diff - 1) <= right) {
          result = max(result, f(left + a - diff - 1, a));
        }
      }
      out.println(result);
    }
  }

  private int f(int x, int a) {
    return x / a + x % a;
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
    try (DivPlusMod instance = new DivPlusMod()) {
      instance.solve();
    }
  }
}
