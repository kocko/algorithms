package codeforces.gyms.gym102219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ToCrashOrNotToCrash implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int taxiRow = -1, taxiCol = -1;
    char[][] grid = new char[3][10];
    for (int i = 0; i < 3; i++) {
      grid[i] = in.next().toCharArray();
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '=') {
          taxiRow = i;
          taxiCol = j;
        }
      }
    }
    char obstacle = '.';
    for (int i = taxiCol + 1; i < grid[taxiRow].length; i++) {
      if (grid[taxiRow][i] != '.') {
        obstacle = grid[taxiRow][i];
        break;
      }
    }
    if (obstacle == '.') {
      out.println("You shall pass!!!");
    } else {
      out.println(obstacle);
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
    try (ToCrashOrNotToCrash instance = new ToCrashOrNotToCrash()) {
      instance.solve();
    }
  }
}
