package codeforces.contests1301_1400.problemset1328;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;

public class KthBeautifulString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long k = in.nl();
      char[] result = new char[n];
      fill(result, 'a');
      long left = 0, right = k;
      long completed = 0;
      while (left <= right) {
        long mid = left + (right - left) / 2;
        if (mid * (mid + 1) <= 2 * k) {
          completed = Math.max(completed, mid);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      long remaining = k - completed * (completed + 1) / 2;
      if (remaining == 0) {
        result[(int) completed - 1] = result[(int) completed] = 'b';
      } else {
        result[(int) completed + 1] = result[(int) remaining - 1] = 'b';
      }
      for (int i = n - 1; i >= 0; i--) {
        out.print(result[i]);
      }
      out.println();
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
    try (KthBeautifulString instance = new KthBeautifulString()) {
      instance.solve();
    }
  }
}
