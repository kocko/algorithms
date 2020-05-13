package atcoder.beginner.contest166;

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

public class IHateFactorization implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private long power(long a) {
    return a * a * a * a * a;
  }

  public void solve() {
    int x = in.ni();
    long limit = 0;
    final long MAX_N = (long) 1e18;
    List<Long> list = new ArrayList<>();
    while (power(limit) <= MAX_N) {
      list.add(limit);
      list.add(-limit);
      limit++;
    }
    list.sort(Comparator.naturalOrder());
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (power(list.get(i)) - power(list.get(j)) == x) {
          out.println(list.get(i) + " " + list.get(j));
          return;
        }
      }
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
    try (IHateFactorization instance = new IHateFactorization()) {
      instance.solve();
    }
  }
}
