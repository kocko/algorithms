package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Alpha implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Alpha() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    char[][] names = new char[26][];
    for (int i = 0; i < 26; i++) {
      String next = in.next();
      StringBuilder name = new StringBuilder();
      int mask = 0;
      for (char c : next.toCharArray()) {
        int p = c - 'A';
        int bit = 1 << p;
        if ((mask & bit) == 0) {
          name.append(c);
          mask |= bit;
        }
      }
      names[i] = name.toString().toCharArray();
    }
    Map<Integer, Long> left = new MiddleCalculator(names, 0, 13).getResult();
    Map<Integer, Long> right = new MiddleCalculator(names, 13, 26).getResult();
    final int ALL = (1 << 26) - 1;
    long result = 0;
    for (Map.Entry<Integer, Long> entry : left.entrySet()) {
      int mask = entry.getKey();
      long a = entry.getValue();
      long b = right.getOrDefault(ALL ^ mask, 0L);
      result += (a * b);
    }
    out.println(result);
  }

  private class MiddleCalculator {
    private char[][] names;
    private int end;
    private Map<Integer, Long> result = new HashMap<>();

    public MiddleCalculator(char[][] names, int start, int end) {
      this.names = names;
      this.end = end;
      recurse(start, 0);
    }

    private void recurse(int idx, int mask) {
      if (idx == end) {
        result.put(mask, result.getOrDefault(mask, 0L) + 1);
      } else {
        for (char c : names[idx]) {
          int p = c - 'A', bit = 1 << p;
          if ((mask & bit) == 0) {
            recurse(idx + 1, mask | bit);
          }
        }
      }
    }

    public Map<Integer, Long> getResult() {
      return result;
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
    try (Alpha instance = new Alpha()) {
      instance.solve();
    }
  }
}
