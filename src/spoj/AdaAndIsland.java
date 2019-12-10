package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AdaAndIsland implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root;
    private int[] size;

    private DisjointSet(int n) {
      root = new int[n + 1];
      size = new int[n + 1];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) y = x ^ y ^ (x = y);
        root[y] = x;
        size[x] += size[y];
      }
    }
  }

  public void solve() {
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] grid = new char[n][m];
      for (int i = 0; i < n; i++) {
        grid[i] = in.next().toCharArray();
      }
      DisjointSet dsu = new DisjointSet(n * m);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == '#') {
            int a = m * i + j;
            for (int[] d : dir) {
              int x = i + d[0], y = j + d[1];
              if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '#') {
                int b = m * x + y;
                dsu.join(a, b);
              }
            }
          }
        }
      }
      long size = 0, total = n * m;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == '#') {
            int idx = m * i + j;
            if (dsu.root(idx) == idx) {
              size += ((long) dsu.size[idx] * dsu.size[idx]);
            }
          }
        }
      }
      long gcd = gcd(size, n * m);
      size /= gcd;
      total /= gcd;
      if (total == 1) {
        out.println(size);
      } else {
        out.println(size + " / " + total);
      }
    }
  }

  private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (AdaAndIsland instance = new AdaAndIsland()) {
      instance.solve();
    }
  }
}
