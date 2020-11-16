package codeforces.contests1401_1500.problemset1430;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringReversal implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class FenwickTree {

    private int MAX;
    private long[] tree;

    private FenwickTree(int N) {
      this.MAX = N;
      tree = new long[MAX + 1];
    }

    private void update(int idx) {
      for (; idx <= MAX; idx += (idx & -idx)) {
        tree[idx]++;
      }
    }

    private long query(int idx) {
      int result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }

  }

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    Map<Character, ArrayDeque<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char c = x[i];
      ArrayDeque<Integer> deque = map.getOrDefault(c, new ArrayDeque<>());
      deque.add(i + 1);
      map.put(c, deque);
    }
    FenwickTree tree = new FenwickTree(n);
    long result = 0;
    for (int i = 0; i < n; i++) {
      char need = x[n - i - 1];
      long index = map.get(need).poll();
      long offset = tree.query((int) index);
      tree.update((int) index + 1);
      index -= offset;
      result += (index - 1);
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
    try (StringReversal instance = new StringReversal()) {
      instance.solve();
    }
  }
}
