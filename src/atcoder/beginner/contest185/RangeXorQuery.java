package atcoder.beginner.contest185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeXorQuery implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), q = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    SegmentTree tree = new SegmentTree(a);
    while (q-- > 0) {
      int type = in.ni();
      if (type == 1) {
        int where = in.ni() - 1, xor = in.ni();
        tree.update(1, where, xor);
      } else {
        int from = in.ni() - 1, to = in.ni() - 1;
        out.println(tree.query(1, from, to));
      }
    }
  }

  private class Node {
    private int lo, hi, value;

    private void xorWith(int value) {
      this.value ^= value;
    }

    private void merge(Node left, Node right) {
      value = left.value ^ right.value;
    }
  }

  private class SegmentTree {
    private int n;
    private int[] x;
    private Node[] tree;

    private SegmentTree(int[] x) {
      this.x = x;
      this.n = x.length;
      tree = new Node[4 * n + 1];
      for (int i = 0; i < tree.length; i++) {
        tree[i] = new Node();
      }
      init(1, 0, n - 1);
    }

    private void init(int idx, int left, int right) {
      tree[idx].lo = left;
      tree[idx].hi = right;
      if (left == right) {
        tree[idx].xorWith(x[left]);
      } else {
        int mid = (left + right) / 2;
        init(idx << 1, left, mid);
        init(idx << 1 | 1, mid + 1, right);
        tree[idx].merge(tree[idx << 1], tree[idx << 1 | 1]);
      }
    }

    private void update(int idx, int where, int value) {
      if (tree[idx].lo == tree[idx].hi) {
        tree[idx].xorWith(value);
      } else {
        int mid = (tree[idx].lo + tree[idx].hi) / 2;
        if (where <= mid) {
          update(idx << 1, where, value);
        } else {
          update(idx << 1 | 1, where, value);
        }
        tree[idx].merge(tree[idx << 1], tree[idx << 1 | 1]);
      }
    }

    public int query(int idx, int left, int right) {
      if (tree[idx].lo > right || tree[idx].hi < left) return 0;
      if (tree[idx].lo >= left && tree[idx].hi <= right) return tree[idx].value;

      int l = query(idx << 1, left, right);
      int r = query(idx << 1 | 1, left, right);
      return l ^ r;
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
    try (RangeXorQuery instance = new RangeXorQuery()) {
      instance.solve();
    }
  }
}
