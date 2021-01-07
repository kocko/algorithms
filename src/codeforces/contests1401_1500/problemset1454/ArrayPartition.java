package codeforces.contests1401_1500.problemset1454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayPartition implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Node {
    private int lo, hi, value;

    private void merge(Node left, Node right) {
      value = Math.min(left.value, right.value);
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
        tree[idx].value = x[left];
      } else {
        int mid = (left + right) / 2;
        init(idx << 1, left, mid);
        init(idx << 1 | 1, mid + 1, right);
        tree[idx].merge(tree[idx << 1], tree[idx << 1 | 1]);
      }
    }

    public int query(int idx, int left, int right) {
      if (tree[idx].lo > right || tree[idx].hi < left) return Integer.MAX_VALUE;
      if (tree[idx].lo >= left && tree[idx].hi <= right) return tree[idx].value;

      int l = query(idx << 1, left, right);
      int r = query(idx << 1 | 1, left, right);
      return Math.min(l, r);
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      int[] max = new int[n];
      max[n - 1] = a[n - 1];
      for (int i = n - 2; i >= 0; i--) {
        max[i] = Math.max(max[i + 1], a[i]);
      }

      SegmentTree tree = new SegmentTree(a);
      int[] result = null;
      int maxSoFar = -1;
      for (int x = 0; x < n - 2 && result == null; x++) {
        maxSoFar = Math.max(maxSoFar, a[x]);
        int left = x + 2, right = n - 1;
        int z_left = n;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (max[mid] == maxSoFar) {
            z_left = Math.min(z_left, mid);
            right = mid - 1;
          } else if (max[mid] > maxSoFar) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }

        int z_right = 0;
        left = x + 2;
        right = n - 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (max[mid] == maxSoFar) {
            z_right = Math.max(z_right, mid);
            left = mid + 1;
          } else if (max[mid] > maxSoFar) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }

        left = z_left - 1;
        right = z_right - 1;

        while (left <= right) {
          int mid = left + (right - left) / 2;
          int min = tree.query(1, x + 1, mid);
          if (maxSoFar == min) {
            result = new int[3];
            result[0] = x + 1;
            result[1] = mid - x;
            result[2] = n - result[0] - result[1];
            break;
          } else if (maxSoFar < min) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }

      }

      if (result != null) {
        out.println("YES");
        for (int idx : result) {
          out.print(idx);
          out.print(' ');
        }
        out.println();
      } else {
        out.println("NO");
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
    try (ArrayPartition instance = new ArrayPartition()) {
      instance.solve();
    }
  }
}
