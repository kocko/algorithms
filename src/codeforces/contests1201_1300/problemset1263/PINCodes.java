package codeforces.contests1201_1300.problemset1263;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class PINCodes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      List<Entry> x = new ArrayList<>();
      Set<String> has = new HashSet<>();
      for (int i = 0; i < n; i++) {
        String value = in.next();
        x.add(new Entry(i, value));
        has.add(value);
      }
      x.sort(Comparator.naturalOrder());
      String[] result = new String[n];
      result[x.get(0).idx] = x.get(0).before;
      int counter = 0, diff = 0;
      for (int i = 1; i < n; i++) {
        char[] value = x.get(i).before.toCharArray();
        if (x.get(i).before.equals(x.get(i - 1).before)) {
          do {
            ++counter;
            int p = (x.get(i).before.charAt(3) - '0' + counter) % 10;
            value[3] = (char) ('0' + p);
          } while (has.contains(new String(value)));
          diff++;
        } else {
          counter = 0;
        }
        result[x.get(i).idx] = new String(value);
      }
      out.println(diff);
      for (int i = 0; i < n; i++) {
        out.println(result[i]);
      }
    }
  }

  private class Entry implements Comparable<Entry> {
    private int idx;
    private String before, now;

    private Entry(int idx, String before) {
      this.idx = idx;
      this.before = before;
    }

    @Override
    public int compareTo(Entry o) {
      return before.compareTo(o.before);
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
    try (PINCodes instance = new PINCodes()) {
      instance.solve();
    }
  }
}
