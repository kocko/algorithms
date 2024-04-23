package codeforces.contests1901_2000.problemset1950;

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

import static java.lang.Math.*;

public class Upscaling implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Upscaling() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      char[][] result = new char[2 * n][2 * n];
      char next = '#';
      for (int row = 0; row < 2 * n - 1; row += 2) {
        char ch = next;
        for (int col = 0; col < 2 * n - 1; col += 2) {
          result[row][col] = result[row + 1][col] = result[row][col + 1] = result[row + 1][col + 1] = ch;
          ch = (ch == '#' ? '.' : '#');
        }
        next = (next == '#' ? '.' : '#');
      }
      for (int i = 0; i < 2 * n; i++) {
        for (int j = 0; j < 2 * n; j++) {
          out.print(result[i][j]);
        }
        out.println();
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
    try (Upscaling instance = new Upscaling()) {
      instance.solve();
    }
  }
}
