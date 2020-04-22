package codeforces.contests001_100.problemset060;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerialTime implements Closeable {

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
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        size[x] += size[y];
        root[y] = x;
      }
    }
  }

  public void solve() {
    int k = in.ni(), n = in.ni(), m = in.ni();
    char[][][] cube = new char[k][n][m];
    for (int i = 0; i < k; i++) {
      char[][] row = new char[n][m];
      for (int j = 0; j < n; j++) {
        row[j] = in.next().toCharArray();
      }
      cube[i] = row;
    }
    DisjointSet dsu = new DisjointSet(n * m * k);
    int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};
    for (int row = 0; row < k; row++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (cube[row][i][j] == '.') {
            int index = row * m * n + m * i + j;
            for (int[] d : dir) {
              int x = i + d[0], y = j + d[1], z = row + d[2];
              if (x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < k && cube[z][x][y] == '.') {
                int idx = z * m * n + m * x + y;
                dsu.join(index, idx);
              }
            }
          }
        }
      }
    }
    int p = in.ni() - 1, q = in.ni() - 1, index = m * p + q, root = dsu.root(index);
    out.println(dsu.size[root]);
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
    try (SerialTime instance = new SerialTime()) {
      instance.solve();
    }
  }
}
