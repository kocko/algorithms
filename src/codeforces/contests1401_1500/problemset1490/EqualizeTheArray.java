package codeforces.contests1401_1500.problemset1490;

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

public class EqualizeTheArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      Map<Integer, Integer> count = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        count.put(next, count.getOrDefault(next, 0) + 1);
      }
      List<Integer> list = new ArrayList<>();
      count.forEach((key, value) -> list.add(value));
      list.sort(Comparator.naturalOrder());
      int result = n + 5;
      for (int i = 0; i < list.size(); i++) {
        int C = list.get(i);
        int more = n - (list.size() - i - 1) * C - C;
        result = Math.min(result, more);
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
    try (EqualizeTheArray instance = new EqualizeTheArray()) {
      instance.solve();
    }
  }
}
