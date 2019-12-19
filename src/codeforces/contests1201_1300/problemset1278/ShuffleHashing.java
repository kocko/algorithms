package codeforces.contests1201_1300.problemset1278;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShuffleHashing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int[] score = score(x, 0, x.length);
      char[] y = in.next().toCharArray();
      boolean ok = false;
      out: for (int start = 0; start < y.length; start++) {
        for (int end = start; end < y.length; end++) {
          int[] s = score(y, start, end + 1);
          if (same(score, s)) {
            ok = true;
            break out;
          }
        }
      }
      out.println(ok ? "YES" : "NO");
    }
  }

  private int[] score(char[] x, int start, int end) {
    int[] result = new int[26];
    for (int i = start; i < end; i++) {
      result[x[i] - 'a']++;
    }
    return result;
  }

  private boolean same(int[] x, int[] y) {
    boolean result = true;
    for (int i = 0; i < x.length; i++) {
      result &= x[i] == y[i];
    }
    return result;
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
    try (ShuffleHashing instance = new ShuffleHashing()) {
      instance.solve();
    }
  }
}
