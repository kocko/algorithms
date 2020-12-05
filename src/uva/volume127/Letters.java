package uva.volume127;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Letters implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX_MASK = 1 << 10;
    while (in.hasNextInt()) {
      int n = in.nextInt();
      char[][] x = new char[n][n];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      int result = oo;
      for (int mask = 0; mask < MAX_MASK; mask++) {
        int dist = bfs(x, mask);
        if (dist < result) {
          result = dist;
        }
      }
      out.println(result == oo ? -1 : result);
    }
  }

  private final int oo = Integer.MAX_VALUE;
  private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private int bfs(char[][] grid, int mask) {
    int n = grid.length;
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = oo;
      }
    }
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    if (isAllowed(grid[0][0], mask)) {
      queue.add(new int[]{0, 0});
      dist[0][0] = 1;
    }
    while (queue.size() > 0) {
      int[] top = queue.pollFirst();
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < n && isAllowed(grid[x][y], mask) && dist[x][y] == oo) {
          dist[x][y] = dist[top[0]][top[1]] + 1;
          queue.add(new int[]{x, y});
        }
      }
    }
    return dist[n - 1][n - 1];
  }

  private boolean isAllowed(char letter, int mask) {
    if (letter >= 'a' && letter <= 'z') {
      int code = letter - 'a';
      return (mask & (1 << code)) == 0;
    } else {
      int code = letter - 'A';
      return (mask & (1 << code)) != 0;
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
    try (Letters instance = new Letters()) {
      instance.solve();
    }
  }
}
