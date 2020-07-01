package codeforces.contests1301_1400.problemset1371;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Grid00100 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      List<int[]> order = new ArrayList<>();

      for (int start = 0; start < n; start++) {
        int col = start;
        for (int row = 0; row < n; row++) {
          order.add(new int[]{row, col});
          col++;
          if (col == n) {
            col = 0;
          }
        }
      }
      int[] r = new int[n], c = new int[n];
      int maxR = 0, minR = Integer.MAX_VALUE;
      int maxC = 0, minC = Integer.MAX_VALUE;
      int[][] result = new int[n][n];
      for (int i = 0; i < k; i++) {
        int[] cell = order.get(i);
        r[cell[0]]++;
        c[cell[1]]++;
        result[cell[0]][cell[1]] = 1;
      }

      for (int i = 0; i < n; i++) {
        maxR = Math.max(maxR, r[i]);
        minR = Math.min(minR, r[i]);

        maxC = Math.max(maxC, c[i]);
        minC = Math.min(minC, c[i]);
      }
      long f = (maxR - minR) * (maxR - minR) + (maxC - minC) * (maxC - minC);
      out.println(f);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
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
    try (Grid00100 instance = new Grid00100()) {
      instance.solve();
    }
  }
}
