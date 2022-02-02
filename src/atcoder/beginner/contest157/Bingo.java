package atcoder.beginner.contest157;

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

public class Bingo implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Bingo() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int[][] grid = new int[3][3];
    boolean[][] marked = new boolean[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = in.ni();
      }
    }
    int n = in.ni();
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          if (grid[j][k] == next) {
            marked[j][k] = true;
          }
        }
      }
    }
    boolean winning = false;
    for (int i = 0; i < 3; i++) winning |= (marked[i][0] && marked[i][1] && marked[i][2]);
    for (int i = 0; i < 3; i++) winning |= (marked[0][i] && marked[1][i] && marked[2][i]);
    winning |= (marked[0][0] && marked[1][1] && marked[2][2]);
    winning |= (marked[0][2] && marked[1][1] && marked[2][0]);
    out.println(winning ? "Yes" : "No");
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
    try (Bingo instance = new Bingo()) {
      instance.solve();
    }
  }
}
