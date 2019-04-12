package codeforces.gyms.gym101755;

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

public class SafePath implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    max = in.ni();
    char[][] grid = new char[n][m];
    dist = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }
    List<int[]> monsters = new ArrayList<>();
    int[] start = null, finish = null;
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 'M') {
          monsters.add(new int[]{i, j});
        } else if (grid[i][j] == 'S') {
          start = new int[]{i, j};
        } else if (grid[i][j] == 'F') {
          finish = new int[]{i, j};
        }
      }
    }
    floodFill(monsters);
    bfs(start, finish);
  }
  
  private int n, m, max;
  private int[][] dist;
  
  private final int oo = Integer.MAX_VALUE;
  private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  
  private void floodFill(List<int[]> monsters) {
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    for (int[] monster : monsters) {
      deque.offerLast(monster);
      dist[monster[0]][monster[1]] = 0;
    }
    while (deque.size() > 0) {
      int[] top = deque.pollFirst();
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && dist[top[0]][top[1]] + 1 <= max && dist[x][y] == oo) {
          dist[x][y] = dist[top[0]][top[1]] + 1;
          deque.add(new int[]{x, y});
        }
      }
    }
  }
  
  private void bfs(int[] start, int[] finish) {
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    int[][] steps = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        steps[i][j] = -1;
      }
    }
    deque.add(start);
    steps[start[0]][start[1]] = 0;
    if (dist[start[0]][start[1]] == oo) {
      while (deque.size() > 0) {
        int[] top = deque.pollFirst();
        for (int[] d : dir) {
          int x = top[0] + d[0], y = top[1] + d[1];
          if (x >= 0 && x < n && y >= 0 && y < m && dist[x][y] == oo && steps[x][y] == -1) {
            steps[x][y] = steps[top[0]][top[1]] + 1;
            deque.offerLast(new int[]{x, y});
          }
        }
      }
    }
    out.println(steps[finish[0]][finish[1]]);
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
    try (SafePath instance = new SafePath()) {
      instance.solve();
    }
  }
}
