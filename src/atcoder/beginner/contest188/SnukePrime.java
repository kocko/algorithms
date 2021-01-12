package atcoder.beginner.contest188;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SnukePrime implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long C = in.nl();
    Set<Long> list = new TreeSet<>();
    long[] a = new long[n], b = new long[n], c = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
      b[i] = in.nl() + 1;
      c[i] = in.nl();
      list.add(a[i]);
      list.add(b[i]);
    }
    List<Long> points = new ArrayList<>(list);
    Map<Long, Integer> indexOf = new HashMap<>();
    int idx = 0;
    for (long point : list) {
      indexOf.put(point, idx++);
    }
    int M = list.size();
    long[] prefix = new long[M];
    for (int i = 0; i < n; i++) {
      long start = a[i], end = b[i];
      prefix[indexOf.get(start)] += c[i];
      prefix[indexOf.get(end)] -= c[i];
    }
    long[] acc = new long[M];
    acc[0] = prefix[0];
    long result = 0;
    for (int i = 0; i < M - 1; i++) {
      if (i >= 1) {
        acc[i] = acc[i - 1] + prefix[i];
      }
      long gap = points.get(i + 1) - points.get(i);
      result += Math.min(acc[i], C) * gap;
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
    try (SnukePrime instance = new SnukePrime()) {
      instance.solve();
    }
  }
}
