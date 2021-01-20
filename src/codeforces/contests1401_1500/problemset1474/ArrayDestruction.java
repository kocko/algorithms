package codeforces.contests1401_1500.problemset1474;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ArrayDestruction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      a = new ArrayList<>();
      for (int i = 0; i < 2 * n; i++) {
        a.add(in.ni());
      }
      a.sort(Comparator.naturalOrder());
      int x = -1;
      List<int[]> result = new ArrayList<>();
      for (int i = 0; i < 2 * n - 1; i++) {
        int start = a.get(i) + a.get(2 * n - 1);
        List<int[]> attempt = go(start);
        if (attempt.size() > 0) {
          x = start;
          result = attempt;
          break;
        }
      }
      if (result.size() > 0) {
        out.println("YES");
        out.println(x);
        for (int[] pair : result) {
          out.println(pair[0] + " " + pair[1]);
        }
      } else {
        out.println("NO");
      }
    }
  }

  private List<Integer> a;

  private List<int[]> go(int x) {
    TreeMap<Integer, Integer> set = new TreeMap<>();
    int prev = a.get(0), count = 1;
    for (int idx = 1; idx < a.size(); idx++) {
      int value = a.get(idx);
      if (value == prev) {
        count++;
      } else {
        set.put(prev, count);
        count = 1;
        prev = value;
      }
    }
    if (count > 0) {
      set.put(prev, count);
    }
    List<int[]> operations = new ArrayList<>();
    while (set.size() > 0) {
      int first = set.lastKey();
      remove(set, first);
      int second = x - first;
      if (set.containsKey(second)) {
        remove(set, second);
        operations.add(new int[]{first, second});
        x = first;
      } else {
        return Collections.emptyList();
      }
    }
    return operations;
  }

  private void add(TreeMap<Integer, Integer> map, int value) {
    map.put(value, map.getOrDefault(value, 0) + 1);
  }

  private void remove(TreeMap<Integer, Integer> map, int value) {
    int cnt = map.get(value);
    if (cnt == 1) {
      map.remove(value);
    } else {
      map.put(value, cnt - 1);
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
    try (ArrayDestruction instance = new ArrayDestruction()) {
      instance.solve();
    }
  }
}
