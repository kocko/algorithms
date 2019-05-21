package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortingTrimmer implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), l = in.ni();
    String s = in.next();
    String s1 = s.substring(0, 1), s2 = s.substring(1);
    char[] x = s2.toCharArray();
    Arrays.sort(x);
    StringBuilder result = new StringBuilder(s1);
    for (int i = 0; i < l - 1; i++) {
      result.append(x[i]);
    }
    char[] p = result.toString().toCharArray();
    Arrays.sort(p);
    for (int i = 0; i < l; i++) {
      out.print(p[i]);
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
    try (SortingTrimmer instance = new SortingTrimmer()) {
      instance.solve();
    }
  }
}
