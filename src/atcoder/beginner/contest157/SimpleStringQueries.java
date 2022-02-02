package atcoder.beginner.contest157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class SimpleStringQueries implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SimpleStringQueries() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class FenwickTree {
    private int MAX;
    private int[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new int[MAX + 1];
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
    int n = in.ni();
    char[] s = in.next().toCharArray();
    int q = in.ni();
    FenwickTree[] trees = new FenwickTree[26];
    for (int i = 0; i < 26; i++) {
      trees[i] = new FenwickTree(n + 1);
    }
    for (int i = 1; i <= n; i++) {
      int idx = s[i - 1] - 'a';
      trees[idx].update(i, +1);
    }
    while (q-- > 0) {
      int type = in.ni();
      if (type == 1) {
        int where = in.ni();
        char replacement = in.next().charAt(0);

        int idx = s[where - 1] - 'a';
        trees[idx].update(where, -1);

        idx = replacement - 'a';
        trees[idx].update(where, +1);

        s[where - 1] = replacement;
      } else {
        int left = in.ni(), right = in.ni();
        int unique = 0;
        for (int i = 0; i < 26; i++) {
          int count = trees[i].query(right) - trees[i].query(left - 1);
          if (count > 0) {
            unique++;
          }
        }
        out.println(unique);
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
    try (SimpleStringQueries instance = new SimpleStringQueries()) {
      instance.solve();
    }
  }
}
