package codeforces.contests501_600.problemset599;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DayAtTheBeach implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> first = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      first.add(in.ni());
    }
    List<Integer> second = new ArrayList<>(first);
    second.sort(Comparator.naturalOrder());
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int i = 0; i < n; i++) {
      int x = first.get(i), y = second.get(i);
      int cnt = map.getOrDefault(x, 0);
      if (cnt == -1) {
        map.remove(x);
      } else {
        map.put(x, cnt + 1);
      }
      cnt = map.getOrDefault(y, 0);
      if (cnt == 1) {
        map.remove(y);
      } else {
        map.put(y, cnt - 1);
      }
      if (map.size() == 0) {
        result++;
      }
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
    try (DayAtTheBeach instance = new DayAtTheBeach()) {
      instance.solve();
    }
  }
}
