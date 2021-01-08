package atcoder.beginner.contest184;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ThirdAvenue implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[][] grid = new char[n][m];
    Map<Character, List<int[]>> teleport = new HashMap<>();
    int[] start = null, end = null;
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
      for (int j = 0; j < m; j++) {
        if (grid[i][j] >= 'a' && grid[i][j] <= 'z') {
          List<int[]> list = teleport.getOrDefault(grid[i][j], new ArrayList<>());
          list.add(new int[]{i, j});
          teleport.put(grid[i][j], list);
        }
        if (grid[i][j] == 'S') {
          start = new int[]{i, j};
        }
        if (grid[i][j] == 'G') {
          end = new int[]{i, j};
        }
      }
    }
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dist = new int[n][m];
    boolean[][] visited = new boolean[n][m];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start[0]][start[1]] = true;
    while (queue.size() > 0 && !visited[end[0]][end[1]]) {
      int[] top = queue.pollFirst();
      char c = grid[top[0]][top[1]];
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '#' && !visited[x][y]) {
          dist[x][y] = dist[top[0]][top[1]] + 1;
          queue.add(new int[]{x, y});
          visited[x][y] = true;
        }
      }
      List<int[]> jumps = teleport.getOrDefault(c, new ArrayList<>());
      for (int[] jump : jumps) {
        if (jump[0] != top[0] || jump[1] != top[1]) {
          if (!visited[jump[0]][jump[1]]) {
            dist[jump[0]][jump[1]] = dist[top[0]][top[1]] + 1;
            queue.add(jump);
            visited[jump[0]][jump[1]] = true;
          }
        }
      }
      if (c >= 'a' && c <= 'z') {
        teleport.put(c, new ArrayList<>());
      }
    }
    out.println(dist[end[0]][end[1]] == 0 ? -1 : dist[end[0]][end[1]]);
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
    try (ThirdAvenue instance = new ThirdAvenue()) {
      instance.solve();
    }
  }
}
