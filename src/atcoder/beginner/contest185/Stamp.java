package atcoder.beginner.contest185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Stamp implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Integer> blue = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      blue.add(in.ni());
    }
    if (m == 0) {
      out.println(1);
      return;
    }
    blue.sort(Comparator.naturalOrder());
    int min = blue.get(0) > 1 ? blue.get(0) - 1 : Integer.MAX_VALUE;
    for (int idx = 1; idx < m; idx++) {
      int white = blue.get(idx) - blue.get(idx - 1) - 1;
      if (white > 0) {
        min = Math.min(min, white);
      }
    }
    if (blue.get(m - 1) < n) {
      min = Math.min(min, n - blue.get(m - 1));
    }
    int result = 0;
    if (blue.get(0) > 1) {
      int white = blue.get(0) - 1;
      result += white / min + (white % min != 0 ? 1 : 0);
    }
    for (int idx = 1; idx < m; idx++) {
      int white = (blue.get(idx) - blue.get(idx - 1) - 1);
      result += white / min + (white % min != 0 ? 1 : 0);
    }
    if (blue.get(m - 1) < n) {
      int size = (n - blue.get(m - 1));
      result += size / min + (size % min != 0 ? 1 : 0);
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
    try (Stamp instance = new Stamp()) {
      instance.solve();
    }
  }
}
