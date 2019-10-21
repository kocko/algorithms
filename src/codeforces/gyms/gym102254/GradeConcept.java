package codeforces.gyms.gym102254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GradeConcept implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Node {
    private int idx, lo, hi, min, max, sum;

    private void merge(Node left, Node right) {
      min = Math.min(left.min, right.min);
      max = Math.max(left.max, right.max);
      sum = left.sum + right.sum;
    }

    private void assign(int value) {
      min = max = sum = value;
    }
  }

  private class SegmentTree {
    private int[] x;
    private Node[] nodes;

    private SegmentTree(int[] x) {
      int n = x.length;
      this.x = x;
      nodes = new Node[4 * n + 1];
      for (int i = 0; i < nodes.length; i++) {
        nodes[i] = new Node();
      }
      init(1, 0, n - 1);
    }

    private void init(int idx, int left, int right) {
      nodes[idx].lo = left;
      nodes[idx].hi = right;
      if (left == right) {
        nodes[idx].assign(x[left]);
      } else {
        int mid = (left + right) / 2;
        init(idx << 1, left, mid);
        init(idx << 1 | 1, mid + 1, right);
        nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
      }
    }

    private int query(int left, int right) {
      Node result = query(1, left, right);
      return result.sum - result.min - result.max;
    }

    private Node query(int idx, int a, int b) {
      if (a <= nodes[idx].lo && nodes[idx].hi <= b) {
        return nodes[idx];
      }
      int mid = (nodes[idx].lo + nodes[idx].hi) / 2;
      if (a > mid) {
        return query(2 * idx + 1, a, b);
      }
      if (b <= mid) {
        return query(2 * idx, a, b);
      }

      Node result = new Node();
      result.merge(query(2 * idx, a, mid), query(2 * idx + 1, mid + 1, b));
      return result;
    }

    private void update(int idx, int value) {
      update(1, idx, idx, value);
    }

    public void update(int idx, int left, int right, int value) {
      if (nodes[idx].lo > right || nodes[idx].hi < left) return;
      if (nodes[idx].lo == left && nodes[idx].hi == right) {
        nodes[idx].assign(value);
        return;
      }
      update(idx << 1, left, right, value);
      update(idx << 1 | 1, left, right, value);
      nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
    }
  }

  public void solve() {
    int n = in.ni(), q = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    SegmentTree tree = new SegmentTree(x);
    while (q-- > 0) {
      int type = in.ni();
      if (type == 1) {
        int left = in.ni() - 1, right = in.ni() - 1;
        out.println(tree.query(left, right));
      } else {
        int idx = in.ni() - 1, value = in.ni();
        tree.update(idx, value);
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
    try (GradeConcept instance = new GradeConcept()) {
      instance.solve();
    }
  }
}
