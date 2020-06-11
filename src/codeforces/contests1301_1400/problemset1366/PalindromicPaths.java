package codeforces.contests1301_1400.problemset1366;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class PalindromicPaths implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] grid = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          grid[i][j] = in.ni();
        }
      }
      int l = n + m - 1;
      int[][] count = new int[l][2];
      int[][] dist = new int[n][m];
      boolean[][] visited = new boolean[n][m];
      ArrayDeque<int[]> queue = new ArrayDeque<>();
      queue.add(new int[]{0, 0});
      visited[0][0] = true;
      count[0][grid[0][0]] = 1;
      final int[][] steps = {{0, 1}, {1, 0}};
      while (queue.size() > 0) {
        int[] top = queue.pollFirst();
        for (int[] step : steps) {
          int x = top[0] + step[0];
          int y = top[1] + step[1];
          if (x < n && y < m && !visited[x][y]) {
            dist[x][y] = dist[top[0]][top[1]] + 1;
            queue.add(new int[]{x, y});
            count[dist[x][y]][grid[x][y]]++;
            visited[x][y] = true;
          }
        }
      }
      int result = 0;
      for (int d = 0; d < l / 2; d++) {
        int min = Integer.MAX_VALUE;
        for (int target = 0; target <= 1; target++) {
          min = Math.min(count[d][target ^ 1] + count[l - d - 1][target ^ 1], min);
        }
        result += min;
      }
      out.println(result);
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
    try (PalindromicPaths instance = new PalindromicPaths()) {
      instance.solve();
    }
  }
}
