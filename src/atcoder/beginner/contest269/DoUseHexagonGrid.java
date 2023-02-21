package atcoder.beginner.contest269;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DoUseHexagonGrid implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public DoUseHexagonGrid() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class DisjointSet {
    private int[] root, size;

    public DisjointSet(int n) {
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
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
      }
    }
  }

  private class Cell {
    private int x, y;

    private Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void solve() {
    int n = in.ni();
    DisjointSet dsu = new DisjointSet(n);
    Cell[] cells = new Cell[n];
    for (int i = 0; i < n; i++) {
      cells[i] = new Cell(in.ni(), in.ni());
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (areNeighbours(cells[i], cells[j])) {
          dsu.join(i, j);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (dsu.root(i) == i) result++;
    }
    out.println(result);
  }

  private static final int[][] DIR = {{-1, -1}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 0}};

  private boolean areNeighbours(Cell a, Cell b) {
    for (int[] d : DIR) {
      if (a.x + d[0] == b.x && a.y + d[1] == b.y) return true;
    }
    return false;
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
    try (DoUseHexagonGrid instance = new DoUseHexagonGrid()) {
      instance.solve();
    }
  }
}
