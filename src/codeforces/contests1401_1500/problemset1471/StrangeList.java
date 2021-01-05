package codeforces.contests1401_1500.problemset1471;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangeList implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), x = in.ni();
      long[] a = new long[n];
      int[] c = new int[n];
      int min = Integer.MAX_VALUE;
      int idx = -1;
      for (int i = 0; i < n; i++) {
        long next = in.nl();
        a[i] = next;
        while (next % x == 0) {
          next /= x;
          c[i]++;
        }
        if (c[i] < min) {
          min = c[i];
          idx = i;
        }
      }
      long sum = 0;
      for (int i = 0; i < n; i++) {
        sum += a[i] * (min + 1);
      }
      for (int i = 0; i < idx; i++) {
        sum += a[i];
      }
      out.println(sum);
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
    try (StrangeList instance = new StrangeList()) {
      instance.solve();
    }
  }
}
