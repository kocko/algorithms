package codeforces.contests1301_1400.problemset1365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SolveTheMaze implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      play();
    }
  }

  private void play() {
    int n = in.ni(), m = in.ni();
    char[][] maze = new char[n][m];
    for (int i = 0; i < n; i++) {
      maze[i] = in.next().toCharArray();
    }
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maze[i][j] == 'B') {
          for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
              if (maze[x][y] == '.') {
                maze[x][y] = '#';
              } else if (maze[x][y] == 'G') {
                out.println("No");
                return;
              }
            }
          }
        }
      }
    }
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    if (maze[n - 1][m - 1] == '.') {
      queue.add(new int[]{n - 1, m - 1});
      maze[n - 1][m - 1] = '*';
    }
    while (queue.size() > 0) {
      int[] top = queue.pollFirst();
      for (int[] d : dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && (maze[x][y] == '.' || maze[x][y] == 'G')) {
          maze[x][y] = '*';
          queue.add(new int[]{x, y});
        }
      }
    }
    boolean ok = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maze[i][j] == 'G') {
          ok = false;
        }
      }
    }
    out.println(ok ? "Yes" : "No");
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
    try (SolveTheMaze instance = new SolveTheMaze()) {
      instance.solve();
    }
  }
}
