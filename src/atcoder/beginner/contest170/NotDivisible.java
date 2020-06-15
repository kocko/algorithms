package atcoder.beginner.contest170;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import static java.util.Comparator.naturalOrder;

public class NotDivisible implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      list.add(next);
      count.put(next, count.getOrDefault(next, 0) + 1);
    }
    list.sort(naturalOrder());
    Set<Integer> has = new HashSet<>();
    int result = 0;
    for (int i = 0; i < n; i++) {
      int next = list.get(i);
      boolean divisible = false;
      for (int d = 1; d * d <= next; d++) {
        if (next % d == 0 && (has.contains(d) || has.contains(next / d))) {
          divisible = true;
          break;
        }
      }
      if (!divisible && count.get(next) == 1) {
        result++;
      }
      has.add(next);
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
    try (NotDivisible instance = new NotDivisible()) {
      instance.solve();
    }
  }
}
