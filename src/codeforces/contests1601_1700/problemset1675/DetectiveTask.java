package codeforces.contests1601_1700.problemset1675;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DetectiveTask implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int result = 0, n = x.length;
      int[] prefix = new int[n + 2];
      int[] suffix = new int[n + 2];
      for (int i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1];
        if (x[i - 1] == '0') {
          prefix[i]++;
        }
      }
      for (int i = n; i >= 1; i--) {
        suffix[i] = suffix[i + 1];
        if (x[i - 1] == '1') {
          suffix[i]++;
        }
      }
      for (int i = 1; i <= n; i++) {
        boolean noZeroesBefore = prefix[i - 1] == 0;
        boolean noOnesAfter = suffix[i + 1] == 0;
        if (noZeroesBefore && noOnesAfter) {
          result++;
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
    try (DetectiveTask instance = new DetectiveTask()) {
      instance.solve();
    }
  }
}
