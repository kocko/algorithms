package atcoder.regular.contest111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ReversibleCards implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;
    private boolean[] tree;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      tree = new boolean[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
        tree[i] = true;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        root[y] = x;
        size[x] += size[y];
        tree[x] &= tree[y];
      } else {
        tree[x] = false;
      }
    }
  }

  public void solve() {
    int n = in.ni();
    final int MAX_A = (int) 4e5;
    DisjointSet dsu = new DisjointSet(MAX_A + 1);
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
      b[i] = in.ni();
      dsu.join(a[i], b[i]);
    }
    Set<Integer> processed = new HashSet<>();
    int result = 0;
    for (int i = 0; i < n; i++) {
      int root = dsu.root(a[i]);
      if (!processed.contains(root)) {
        if (dsu.tree[root]) {
          result += dsu.size[root] - 1;
        } else {
          result += dsu.size[root];
        }
        processed.add(root);
      }
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
    try (ReversibleCards instance = new ReversibleCards()) {
      instance.solve();
    }
  }
}
