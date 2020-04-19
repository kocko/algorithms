package atcoder.beginner.contest160;

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

public class RedAndGreenApples implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int x = in.ni(), y = in.ni(), a = in.ni(), b = in.ni(), c = in.ni();
    List<Long> red = new ArrayList<>(), green = new ArrayList<>(), white = new ArrayList<>();
    for (int i = 0; i < a; i++) red.add(in.nl());
    for (int i = 0; i < b; i++) green.add(in.nl());
    for (int i = 0; i < c; i++) white.add(in.nl());
    red.sort(Comparator.reverseOrder());
    green.sort(Comparator.reverseOrder());
    white.sort(Comparator.reverseOrder());

    List<Long> eat = new ArrayList<>();
    for (int i = 0; i < x; i++) eat.add(red.get(i));
    for (int i = 0; i < y; i++) eat.add(green.get(i));

    eat.sort(Comparator.naturalOrder());

    List<Long> eatPrefix = new ArrayList<>();
    eatPrefix.add(eat.get(0));
    for (int i = 1; i < eat.size(); i++) {
      eatPrefix.add(eatPrefix.get(i - 1) + eat.get(i));
    }
    List<Long> whitePrefix = new ArrayList<>();
    whitePrefix.add(white.get(0));
    for (int i = 1; i < white.size(); i++) {
      whitePrefix.add(whitePrefix.get(i - 1) + white.get(i));
    }
    long result = eatPrefix.get(x + y - 1);
    for (int i = 1; i <= Math.min(x + y, white.size()); i++) {
      result = Math.max(result, whitePrefix.get(i - 1) + eatPrefix.get(eatPrefix.size() - 1) - eatPrefix.get(i - 1));
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
    try (RedAndGreenApples instance = new RedAndGreenApples()) {
      instance.solve();
    }
  }
}
