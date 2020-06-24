package codeforces.contests1301_1400.problemset1369;

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

public class RationalLee implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      List<Long> x = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        x.add(in.nl());
      }
      x.sort(Comparator.reverseOrder());
      List<Integer> cnt = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        cnt.add(in.ni() - 1);
      }
      cnt.sort(Comparator.naturalOrder());
      long result = 0;
      for (int i = 0; i < k; i++) {
        result += x.get(i);
        if (cnt.get(i) == 0) {
          result += x.get(i);
        }
      }
      int idx = k;
      for (int i = 0; i < k; i++) {
        int need = cnt.get(i);
        if (need > 0) {
          result += x.get(idx + need - 1);
          idx += need;
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
    try (RationalLee instance = new RationalLee()) {
      instance.solve();
    }
  }
}
