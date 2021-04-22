package usaco.year2019.january;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShellGame implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ShellGame() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("shell.in"));
    out = new PrintWriter(new FileOutputStream("shell.out"));
  }

  public void solve() {
    int n = in.ni();
    int[][] swaps = new int[n][3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        swaps[i][j] = in.ni();
      }
    }
    int result = 0;
    for (int shell = 1; shell <= 3; shell++) {
      int pebble = shell;
      int score = 0;
      for (int[] swap : swaps) {
        if (swap[0] == pebble) {
          pebble = swap[1];
        } else if (swap[1] == pebble) {
          pebble = swap[0];
        }

        if (swap[2] == pebble) {
          score++;
        }
      }
      if (score > result) {
        result = score;
      }
    }
    out.println(result);
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
    try (ShellGame instance = new ShellGame()) {
      instance.solve();
    }
  }
}
