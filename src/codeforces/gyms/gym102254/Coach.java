package codeforces.gyms.gym102254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Coach implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), x = in.ni(), d = in.ni(), teams = 0;
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
    }
    for (int i = 0; i < (1 << n); i++) {
      long total = 0, max = 0, min = Integer.MAX_VALUE;
      for (int j = 0; j < n; j++) {
        int bit = 1 << j;
        if ((i & bit) != 0) {
          max = Math.max(a[j], max);
          min = Math.min(a[j], min);
          total += a[j];
        }
      }
      if (total >= x && max - min >= 0 && max - min <= d) {
        teams++;
      }

    }
    out.println(teams);
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
    try (Coach instance = new Coach()) {
      instance.solve();
    }
  }
}
