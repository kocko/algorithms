package atcoder.beginner.contest276;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RoundTrip implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    grid = new char[n][m];
    int startX = -1, startY = -1;
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 'S') {
          startX = i;
          startY = j;
        }
      }
    }
    visited = new boolean[n][m];
    componentNumber = new int[n][m];

    int component = 1;
    List<int[]> closest = new ArrayList<>();
    for (int[] d : DIR) {
      int x = startX + d[0], y = startY + d[1];
      if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.') {
        closest.add(new int[]{x, y});
        if (!visited[x][y]) {
          dfs(x, y, component++);
        }
      }
    }

    boolean can = false;
    int k = closest.size();
    for (int i = 0; i < k; i++) {
      for (int j = i + 1; j < k; j++) {
        int[] a = closest.get(i), b = closest.get(j);
        can |= (componentNumber[a[0]][a[1]] == componentNumber[b[0]][b[1]]);
      }
    }

    out.println(can ? "Yes" : "No");
  }

  private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private int n, m;
  private char[][] grid;
  private int[][] componentNumber;
  private boolean[][] visited;

  private void dfs(int row, int col, int component) {
    visited[row][col] = true;
    componentNumber[row][col] = component;
    for (int[] d : DIR) {
      int x = row + d[0], y = col + d[1];
      if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.' && !visited[x][y]) {
        dfs(x, y, component);
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
    try (RoundTrip instance = new RoundTrip()) {
      instance.solve();
    }
  }
}