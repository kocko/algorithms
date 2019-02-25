package codeforces.contests1101_1200.problemset1130;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Connect implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return root[x] == x ? x : (root[x] = root(root[x]));
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
    int n = in.ni();
    int x1 = in.ni() - 1, y1 = in.ni() - 1;
    int x2 = in.ni() - 1, y2 = in.ni() - 1;
    char[][] grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    DisjointSet dsu = new DisjointSet(n * n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '0') {
          int p = n * i + j;
          for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == '0') {
              int q = n * x + y;
              dsu.join(p, q);
            }
          }
        }
      }
    }
    int result = Integer.MAX_VALUE;
    int a = n * x1 + y1, b = n * x2 + y2;
    int r1 = dsu.root(a), r2 = dsu.root(b);
    if (r1 != r2) {
      List<int[]> x = new ArrayList<>(), y = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '0') {
            int number = n * i + j, root = dsu.root(number);
            if (root == r1) {
              x.add(new int[]{i, j});
            } else if (root == r2) {
              y.add(new int[]{i, j});
            }
          }
        }
      }
      for (int[] c1 : x) {
        for (int[] c2 : y) {
          int dist = (c1[0] - c2[0]) * (c1[0] - c2[0]) + (c1[1] - c2[1]) * (c1[1] - c2[1]);
          if (dist < result) {
            result = dist;
          }
        }
      }
    } else {
      result = 0;
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
    try (Connect instance = new Connect()) {
      instance.solve();
    }
  }
}
