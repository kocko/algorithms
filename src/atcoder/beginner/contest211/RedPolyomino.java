package atcoder.beginner.contest211;

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

public class RedPolyomino implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public RedPolyomino() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public RedPolyomino(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    k = in.ni();
    grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '.') {
          long bit = 1L << (n * i + j);
          grid[i][j] = '@';
          recurse(k - 1, bit);
          grid[i][j] = '.';
        }
      }
    }
    out.println(result);
  }

  private int n, k;
  private char[][] grid;
  private int result;
  private Set<Long> visited;
  private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private void recurse(int rem, long mask) {
    visited.add(mask);
    if (rem == 0) {
      result++;
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '@') {
            for (int[] d : dir) {
              int x = i + d[0], y = j + d[1];
              if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == '.') {
                int bit = n * x + y;
                long nmask = mask | (1L << bit);
                if (!visited.contains(nmask)) {
                  grid[x][y] = '@';
                  recurse(rem - 1, nmask);
                  grid[x][y] = '.';
                }
              }
            }
          }
        }
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
    try (RedPolyomino instance = new RedPolyomino()) {
      instance.solve();
    }
  }
}
