package codeforces.contests301_400.problemset374;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InnaAndSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni(), m = in.ni();
    int[] hit = new int[m];
    for (int i = 0; i < m; i++) {
      hit[i] = in.ni();
    }
    FenwickTree tree = new FenwickTree();
    int[] value = new int[MAX_N + 1];
    boolean[] deleted = new boolean[MAX_N + 1];
    int idx = 0;
    while (q-- > 0) {
      int type = in.ni();
      if (type == -1) {
        int current = tree.query(idx);
        List<Integer> delete = new ArrayList<>();
        for (int i = 0; i < m; i++) {
          if (hit[i] > current) break;
          int left = 1, right = idx;
          int target = hit[i], p = idx + 5;
          while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = tree.query(mid);
            if (count > target) {
              right = mid - 1;
            } else if (count < target) {
              left = mid + 1;
            } else {
              p = Math.min(p, mid);
              right = mid - 1;
            }
          }
          if (p != idx + 5) {
            delete.add(p);
          }
        }
        for (int i = delete.size() - 1; i >= 0; i--) {
          int p = delete.get(i);
          deleted[p] = true;
          tree.update(p, -1);
        }
      } else {
        value[++idx] = type;
        tree.update(idx, 1);
      }
    }
    int count = tree.query(idx);
    if (count > 0) {
      for (int i = 1; i <= idx; i++) {
        if (!deleted[i]) {
          out.print(value[i]);
        }
      }
    } else {
      out.println("Poor stack!");
    }
  }

  private static final int MAX_N = (int) 1e6;

  private class FenwickTree {
    private int[] tree;

    private FenwickTree() {
      tree = new int[MAX_N + 1];
    }

    private void update(int idx, int delta) {
      for (; idx <= MAX_N; idx += (idx & -idx)) {
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
    try (InnaAndSequence instance = new InnaAndSequence()) {
      instance.solve();
    }
  }
}
