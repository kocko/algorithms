package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AndRounds implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Node {
    private int left, right, value;

    private void merge(Node left, Node right) {
      value = (left.value & right.value);
    }
  }

  private class SegmentTree {
    private Node[] nodes;
    private int[] x;

    private SegmentTree(int[] x) {
      int n = x.length;
      nodes = new Node[4 * n + 1];
      for (int i = 0; i < nodes.length; i++) {
        nodes[i] = new Node();
      }
      this.x = x;
      init(1, 0, n - 1);
    }

    private void init(int idx, int left, int right) {
      nodes[idx].left = left;
      nodes[idx].right = right;
      if (left == right) {
        nodes[idx].value = x[left];
        return;
      }
      int mid = (left + right) / 2;
      init(idx << 1, left, mid);
      init(idx << 1 | 1, mid + 1, right);
      nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
    }

    private int query(int left, int right) {
      return query(1, left, right).value;
    }

    private Node query(int idx, int left, int right) {
      if (nodes[idx].left > right || nodes[idx].right < left) {
        Node result = new Node();
        result.value = (1 << 30) - 1;
        return result;
      }
      if (left <= nodes[idx].left && nodes[idx].right <= right) return nodes[idx];
      Node result = new Node();
      result.merge(query(idx << 1, left, right), query(idx << 1 | 1, left, right));
      return result;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni(), and = 0;
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (i == 0) {
          and = x[i];
        } else {
          and &= x[i];
        }
      }
      SegmentTree tree = new SegmentTree(x);
      for (int i = 0; i < n; i++) {
        if (k > n / 2) {
          x[i] = and;
        } else {
          if (i + k >= n) {
            x[i] &= tree.query(i, n - 1);
            x[i] &= tree.query(0, (i + k) % n);
          } else {
            x[i] &= tree.query(i, i + k);
          }
          if (i - k < 0) {
            x[i] &= tree.query(0, i);
            x[i] &= tree.query(n - k + i, n - 1);
          } else {
            x[i] &= tree.query(i - k, i);
          }
        }
        out.print(x[i]);
        out.print(' ');
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
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (AndRounds instance = new AndRounds()) {
      instance.solve();
    }
  }
}
