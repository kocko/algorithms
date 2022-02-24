package codeforces.contests1601_1700.problemset1642;

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

public class GreatSequence implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GreatSequence() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), x = in.ni();
      Map<Long, Integer> low = new HashMap<>();
      Map<Long, Integer> high = new HashMap<>();
      for (int i = 0; i < n; i++) {
        long next = in.nl();
        if (next % x == 0) {
          high.put(next, high.getOrDefault(next, 0) + 1);
        } else {
          low.put(next, low.getOrDefault(next, 0) + 1);
        }
      }
      int result = 0;
      for (Map.Entry<Long, Integer> entry : low.entrySet()) {
        long value = entry.getKey(), count = entry.getValue(), target = value * x;
        while (count-- > 0) {
          int matchCount = high.getOrDefault(target, 0);
          if (matchCount == 0) {
            result++;
          } else {
            if (matchCount == 1) {
              high.remove(target);
            } else {
              high.put(target, matchCount - 1);
            }
          }
        }
      }
      List<Long> remaining = new ArrayList<>();
      for (Map.Entry<Long, Integer> entry : high.entrySet()) {
        long value = entry.getKey(), count = entry.getValue();
        for (int i = 0; i < count; i++) {
          remaining.add(value);
        }
      }
      remaining.sort(Comparator.naturalOrder());
      for (long value : remaining) {
        if (high.containsKey(value)) {
          long target = value * x;
          int count = high.getOrDefault(target, 0);
          if (count == 0) {
            result++;
          } else if (count == 1) {
            high.remove(target);
          } else {
            high.put(target, count - 1);
          }
          count = high.get(value);
          if (count == 1) {
            high.remove(value);
          } else {
            high.put(value, count - 1);
          }
        }
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
    try (GreatSequence instance = new GreatSequence()) {
      instance.solve();
    }
  }
}
