package codeforces.contests1201_1300.problemset1293;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NekosMazeGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), q = in.ni();
    boolean[][] lava = new boolean[2][n];
    Set<Integer> one = new HashSet<>(), two = new HashSet<>();
    while (q-- > 0) {
      int row = in.ni() - 1, col = in.ni() - 1;
      lava[row][col] = !lava[row][col];
      int alt = (row + 1) % 2;
      if (lava[row][col]) {
        if (lava[alt][col]) {
          one.add(col);
        } else {
          if (col >= 1 && lava[alt][col - 1]) {
            two.add(col - 1);
          }
          if (col < n - 1 && lava[alt][col + 1]) {
            two.add(col);
          }
        }
      } else {
        one.remove(col);
        if (col >= 1 && lava[alt][col - 1]) {
          two.remove(col - 1);
        }
        if (col < n - 1 && lava[alt][col + 1]) {
          two.remove(col);
        }
        if (col < n - 1 && lava[alt][col] && lava[row][col + 1]) {
          two.add(col);
        }
        if (col >= 1 && lava[alt][col] && lava[row][col - 1]) {
          two.add(col - 1);
        }
      }
      boolean possible = two.size() == 0 && one.size() == 0;
      out.println(possible ? "Yes" : "No");
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
    try (NekosMazeGame instance = new NekosMazeGame()) {
      instance.solve();
    }
  }
}
