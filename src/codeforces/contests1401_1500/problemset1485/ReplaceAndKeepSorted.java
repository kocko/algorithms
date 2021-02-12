package codeforces.contests1401_1500.problemset1485;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReplaceAndKeepSorted implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), q = in.ni(), k = in.ni();
    long[] a = new long[n + 1], score = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nl();
    }
    for (int i = 2; i < n; i++) {
      score[i] = a[i + 1] - a[i - 1] - 1;
    }
    score[1] = a[1] - 1;
    score[n] = k - a[n - 1];
    for (int i = 1; i <= n; i++) {
      score[i] += score[i - 1];
    }

    while (q-- > 0) {
      int left = in.ni(), right = in.ni(), size = right - left + 1;
      long result;
      if (size == 1) {
        result = k - 1;
      } else {
        result = a[left + 1] - 1 + k - a[right - 1] - size;
        if (size >= 3) {
          result += score[right - 1] - score[left];
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
    try (ReplaceAndKeepSorted instance = new ReplaceAndKeepSorted()) {
      instance.solve();
    }
  }
}
