package codeforces.contests1201_1300.problemset1234;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DistinctCharactersQueries implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class FenwickTree {
    private int MAX;
    private long[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new long[MAX + 1];
    }

    private void update(int idx, int delta) {
      for (; idx <= MAX; idx += (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private int query(int idx) {
      int result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    final int MAX_N = (int) 1e5 + 5;
    FenwickTree[] trees = new FenwickTree[26];
    for (int i = 0; i < 26; i++) {
      trees[i] = new FenwickTree(MAX_N);
    }
    char[] x = in.next().toCharArray();
    for (int i = 1; i <= x.length; i++) {
      int idx = x[i - 1] - 'a';
      trees[idx].update(i, 1);
    }

    int q = in.ni();
    while (q-- > 0) {
      int type = in.ni();
      if (type == 1) {
        int idx = in.ni();
        char ch = in.next().charAt(0);
        char old = x[idx - 1];
        trees[old - 'a'].update(idx, -1);
        trees[ch - 'a'].update(idx, + 1);
        x[idx - 1] = ch;
      } else {
        int left = in.ni(), right = in.ni();
        int distinct = 0;
        for (int i = 0; i < 26; i++) {
          int cnt = trees[i].query(right) - trees[i].query(left - 1);
          if (cnt > 0) {
            distinct++;
          }
        }
        out.println(distinct);
      }
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
    try (DistinctCharactersQueries instance = new DistinctCharactersQueries()) {
      instance.solve();
    }
  }
}
