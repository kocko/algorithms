package usaco.year2012.january;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class HaybaleStacking implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public HaybaleStacking() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] x = new int[n + 1];
    while (k-- > 0) {
      int left = in.ni(), right = in.ni();
      x[left]++;
      if (right + 1 <= n) {
        x[right + 1]--;
      }
    }
    for (int i = 1; i <= n; i++) {
      x[i] += x[i - 1];
    }
    Arrays.sort(x);
    out.println(x[(n + 1) / 2]);
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
    try (HaybaleStacking instance = new HaybaleStacking()) {
      instance.solve();
    }
  }
}
