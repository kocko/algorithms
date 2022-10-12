package codeforces.contests1701_1800.problemset1741;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FunnyPermutation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      if (n == 3) {
        out.println(-1);
      } else {
        build(n);
      }
    }
  }

  private void build(int n) {
    int[] result = new int[n];
    int start = n / 2;
    int next = 1;
    for (int i = start; i < n; i++, next++) {
      result[i] = next;
    }
    for (int i = 0; i < start; i++, next++) {
      result[i] = next;
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
    }
    out.println();
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
    try (FunnyPermutation instance = new FunnyPermutation()) {
      instance.solve();
    }
  }
}