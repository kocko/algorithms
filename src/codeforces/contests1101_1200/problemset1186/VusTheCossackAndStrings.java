package codeforces.contests1101_1200.problemset1186;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VusTheCossackAndStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] a = in.next().toCharArray();
    int n = a.length;
    char[] b = in.next().toCharArray();
    int m = b.length;
    int[] a1 = new int[n + 1], a2 = new int[m + 1];
    for (int i = 1; i <= n; i++) {
      a1[i] = a1[i - 1] + (a[i - 1] - '0');
    }
    for (int i = 1; i <= m; i++) {
      a2[i] = a2[i - 1] + (b[i - 1] - '0');
    }
    int result = 0;
    for (int i = m; i <= n; i++) {
      if ((a1[i] - a1[i - m]) % 2 == (a2[m] % 2)) {
        result++;
      }
    }
    out.println(result);
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
    try (VusTheCossackAndStrings instance = new VusTheCossackAndStrings()) {
      instance.solve();
    }
  }
}
