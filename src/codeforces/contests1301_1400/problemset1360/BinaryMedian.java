package codeforces.contests1301_1400.problemset1360;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class BinaryMedian implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      long MAX = (1L << n) - 1;

      List<Long> deleted = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        deleted.add(parseLong(in.next(), 2));
      }
      deleted.sort(Comparator.naturalOrder());
      Map<Long, Long> prev = new HashMap<>();
      Set<Long> history = new HashSet<>();
      long median = MAX / 2;
      for (long delete : deleted) {
        if (delete == median) {
          if (history.size() % 2 == 1) {
            median = prev.getOrDefault(median, median - 1);
          } else {
            median++;
          }
          long next = delete + 1;
          long pointTo = prev.getOrDefault(delete, delete - 1);
          if (pointTo >= 0) {
            prev.put(next, pointTo);
            prev.remove(delete);
          }
        } else if (delete < median) {
          if (history.size() % 2 == 0) {
            median++;
          }
          long next = delete + 1;
          long pointTo = prev.getOrDefault(delete, delete - 1);
          if (pointTo >= 0) {
            prev.put(next, pointTo);
            prev.remove(delete);
          }
        } else {
          if (history.size() % 2 == 1) {
            median = prev.getOrDefault(median, median - 1);
          }
        }
        history.add(delete);
      }

      char[] result = new char[n];
      int idx = n - 1;
      while (idx >= 0) {
        result[idx--] = (char) ('0' + (median % 2));
        median /= 2;
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
      }
      out.println();
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
      return parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (BinaryMedian instance = new BinaryMedian()) {
      instance.solve();
    }
  }
}
