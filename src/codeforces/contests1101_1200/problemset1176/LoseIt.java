package codeforces.contests1101_1200.problemset1176;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class LoseIt implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    Map<Integer, TreeSet<Integer>> sets = new HashMap<>();
    for (int idx = 0; idx < n; idx++) {
      int next = in.ni();
      TreeSet<Integer> set = sets.getOrDefault(next, new TreeSet<>());
      set.add(idx);
      sets.put(next, set);
    }
    int result = 0;
    int[] numbers = {4, 8, 15, 16, 23, 42};
    out:
    while (true) {
      int ceil = -1, count = 0;
      for (int number : numbers) {
        TreeSet<Integer> set = sets.getOrDefault(number, new TreeSet<>());
        Integer idx = set.ceiling(ceil);
        if (idx == null) {
          result += count;
          break out;
        } else {
          count++;
          ceil = idx;
          set.remove(idx);
          if (set.size() == 0) {
            sets.remove(number);
          }
        }
      }
    }
    for (TreeSet<Integer> set : sets.values()) {
      result += set.size();
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
    try (LoseIt instance = new LoseIt()) {
      instance.solve();
    }
  }
}
