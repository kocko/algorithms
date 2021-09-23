package atcoder.beginner.contest219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Moat implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Moat() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Moat(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int[][] grid = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        grid[i][j] = in.ni();
      }
    }
    int result = 0;
    for (int mask = 1; mask < (1 << 16); mask++) {
      if (allExternalComponentsTouchBorders(mask) && areHousesInsideMoat(mask, grid)) {
        result++;
      }
    }
    out.println(result);
  }

  private boolean allExternalComponentsTouchBorders(int mask) {
    int[][] grid = new int[4][4];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < 16; i++) {
      int bit = 1 << i;
      int row = i / 4, col = i % 4;
      if ((mask & bit) != 0) {
        grid[row][col] = 1;
        if (queue.size() == 0) {
          queue.add(new int[]{row, col});
        }
      }
    }
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited = new boolean[4][4];
    while (queue.size() > 0) {
      int[] top = queue.pollFirst();
      visited[top[0]][top[1]] = true;
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < 4 && y >= 0 && y < 4 && grid[x][y] == 1 && !visited[x][y]) {
          queue.add(new int[]{x, y});
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if ((i == 0 || j == 0 || i == 3 || j == 3) && grid[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }
    while (queue.size() > 0) {
      int[] top = queue.pollFirst();
      visited[top[0]][top[1]] = true;
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < 4 && y >= 0 && y < 4 && grid[x][y] == 0 && !visited[x][y]) {
          queue.add(new int[]{x, y});
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (!visited[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean areHousesInsideMoat(int mask, int[][] grid) {
    boolean result = true;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (grid[i][j] == 1) {
          int idx = 4 * i + j;
          int bit = 1 << idx;
          result &= (mask & bit) != 0;
        }
      }
    }
    return result;
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
    try (Moat instance = new Moat()) {
      instance.solve();
    }
  }
}
