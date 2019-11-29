package codeforces.contests001_100.problemset008;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ObsessionWithRobots implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    boolean[][] visited = new boolean[300][300];
    int[] current = {150, 150};
    boolean ok = true;
    final int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    for (char c : x) {
      visited[current[0]][current[1]] = true;
      if (c == 'R') current[0]++;
      else if (c == 'L') current[0]--;
      else if (c == 'U') current[1]++;
      else current[1]--;

      int neighbours = 0;
      for (int[] d : dir) {
        int a = current[0] + d[0], b = current[1] + d[1];
        if (visited[a][b]) {
          neighbours++;
        }
      }
      if (visited[current[0]][current[1]] || neighbours > 1) {
        ok = false;
        break;
      }
    }
    out.println(ok ? "OK" : "BUG");
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
    try (ObsessionWithRobots instance = new ObsessionWithRobots()) {
      instance.solve();
    }
  }
}
