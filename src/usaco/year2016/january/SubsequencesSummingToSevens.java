package usaco.year2016.january;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class SubsequencesSummingToSevens implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SubsequencesSummingToSevens() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("div7.in"));
    out = new PrintWriter(new FileOutputStream("div7.out"));
  }

  public void solve() {
    int n = in.ni();
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    int result = 0;
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      sum = (sum + next) % 7;
      if (map.containsKey(sum)) {
        int where = map.get(sum);
        result = max(result, i - where);
      }
      map.putIfAbsent(sum, i);
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
    try (SubsequencesSummingToSevens instance = new SubsequencesSummingToSevens()) {
      instance.solve();
    }
  }
}
