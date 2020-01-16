package codeforces.contests1201_1300.problemset1285;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DrEvilUnderscores implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.ni());
    }
    out.println(recurse(31, list));
  }

  private Integer recurse(int idx, List<Integer> list) {
    if (idx < 0) return 0;

    List<Integer> one = new ArrayList<>();
    List<Integer> zero = new ArrayList<>();
    int bit = 1 << idx;
    for (Integer number : list) {
      if ((number & bit) != 0) {
        one.add(number);
      } else {
        zero.add(number);
      }
    }
    if (zero.size() == 0) return recurse(idx - 1, one);
    if (one.size() == 0) return recurse(idx - 1, zero);

    return bit + Math.min(recurse(idx - 1, one), recurse(idx - 1, zero));
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
    try (DrEvilUnderscores instance = new DrEvilUnderscores()) {
      instance.solve();
    }
  }
}
