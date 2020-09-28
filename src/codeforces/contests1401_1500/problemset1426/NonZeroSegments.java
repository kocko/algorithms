package codeforces.contests1401_1500.problemset1426;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NonZeroSegments implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    while (t-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      Set<Long> set = new HashSet<>();
      set.add(0L);
      long prefix = 0L;
      int result = 0;
      for (int i = 0; i < n; i++) {
        prefix += x[i];
        if (set.contains(prefix)) {
          result++;
          set.clear();
          set.add(0L);
          prefix = x[i];
        }
        set.add(prefix);
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
    try (NonZeroSegments instance = new NonZeroSegments()) {
      instance.solve();
    }
  }
}
