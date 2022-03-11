package codeforces.contests1601_1700.problemset1647;

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

public class MadokaAndChildishPranks implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MadokaAndChildishPranks() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] x = new char[n][m];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      boolean possible = true;
      List<int[]> result = new ArrayList<>();
      int row = n - 1, col = m - 1;
      out:
      while (row >= 0) {
        while (col >= 0) {
          if (x[row][col] == '1') {
            if (col - 1 >= 0) {
              result.add(new int[]{row, col - 1, row, col});
            } else {
              if (row - 1 >= 0) {
                result.add(new int[]{row - 1, col, row, col});
              } else {
                possible = false;
                break out;
              }
            }
          }
          col--;
        }
        row--;
        col = m - 1;
      }
      if (possible) {
        out.println(result.size());
        for (int[] rect : result) {
          for (int coordinate : rect) {
            out.print(coordinate + 1);
            out.print(' ');
          }
          out.println();
        }
      } else {
        out.println(-1);
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
    try (MadokaAndChildishPranks instance = new MadokaAndChildishPranks()) {
      instance.solve();
    }
  }
}
