package codeforces.contests1401_1500.problemset1450;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ErrichTacToeEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[][] x = new char[n][n];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      int[] count = new int[3];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (x[i][j] == 'X') {
            count[(i + j) % 3]++;
          }
        }
      }
      int min = n * n + 1, idx = -1;
      for (int i = 0; i < 3; i++) {
        if (count[i] < min) {
          min = count[i];
          idx = i;
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (x[i][j] == 'X') {
            if ((i + j) % 3 == idx) {
              out.print('O');
            } else {
              out.print('X');
            }
          } else {
            out.print(x[i][j]);
          }
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
    try (ErrichTacToeEasy instance = new ErrichTacToeEasy()) {
      instance.solve();
    }
  }
}
