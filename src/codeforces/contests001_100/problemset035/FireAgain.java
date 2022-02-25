package codeforces.contests001_100.problemset035;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class FireAgain implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FireAgain(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    int[][] result = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[i][j] = -1;
      }
    }
    int max = -1, lastX = -1, lastY = -1;
    for (int i = 0; i < k; i++) {
      int x = in.ni() - 1, y = in.ni() - 1;
      queue.add(new int[]{x, y});
      result[x][y] = 0;
      max = 0;
      lastX = x;
      lastY = y;
    }
    final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    while (queue.size() > 0) {
      int[] top = queue.pollFirst();
      for (int[] d: dir) {
        int x = top[0] + d[0], y = top[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && result[x][y] == -1) {
          result[x][y] = result[top[0]][top[1]] + 1;
          queue.add(new int[]{x, y});
          if (result[x][y] > max) {
            max = result[x][y];
            lastX = x;
            lastY = y;
          }
        }
      }
    }
    out.println((lastX + 1) + " " + (lastY + 1));
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
    try (FireAgain instance = new FireAgain("input.txt", "output.txt")) {
      instance.solve();
    }
  }
}
