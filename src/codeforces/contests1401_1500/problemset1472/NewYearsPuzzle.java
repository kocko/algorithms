package codeforces.contests1401_1500.problemset1472;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NewYearsPuzzle implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      TreeMap<Integer, Integer> map = new TreeMap<>();
      map.put(0, 3);
      map.put(n + 1, 3);
      for (int i = 0; i < m; i++) {
        int r = in.ni(), c = in.ni();
        map.put(c, map.getOrDefault(c, 0) | r);
      }
      boolean can = true;
      List<Integer> columns = new ArrayList<>(map.keySet());
      int p = columns.size();
      boolean[] resolved = new boolean[p];
      resolved[0] = resolved[p - 1] = true;

      for (int i = 1; i < p - 1; i++) {
        int prev = map.get(columns.get(i - 1)), next = map.get(columns.get(i + 1)), current = map.get(columns.get(i));
        if (prev == 3 && next == 3 && current != 3) {
          can = false;
          break;
        }
      }

      if (can) {
        for (int i = 1; i < p; i++) {
          if (map.get(columns.get(i)) == 3) {
            resolved[i] = true;
            continue;
          }
          if (!resolved[i] && !resolved[i - 1]) {
            int gap = columns.get(i) - columns.get(i - 1) + 1;
            int m1 = map.get(columns.get(i)), m2 = map.get(columns.get(i - 1));
            if ((m1 == 1 && m2 == 1) || (m1 == 2 && m2 == 2)) {
              can &= gap % 2 == 0;
            } else if ((m1 == 1 && m2 == 2) || (m1 == 2 && m2 == 1)) {
              can &= gap % 2 == 1;
            }
            if (can) {
              resolved[i] = resolved[i - 1] = true;
            }
          }
        }
        for (int i = 0; i < p; i++) {
          can &= resolved[i];
        }
      }
      out.println(can ? "YES" : "NO");
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
    try (NewYearsPuzzle instance = new NewYearsPuzzle()) {
      instance.solve();
    }
  }
}
