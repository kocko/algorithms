package codeforces.contests1301_1400.problemset1360;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ABMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), a = in.ni(), b = in.ni();
      byte[][] result = new byte[n][m];
      int[] row = new int[n];
      ArrayDeque<Integer> order = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        order.add(i);
      }
      for (int col = 0; col < m; col++) {
        for (int i = 0; i < b; i++) {
          int selectedRow = order.pollFirst();
          result[selectedRow][col] = 1;
          row[selectedRow]++;
          order.addLast(selectedRow);
        }
      }
      boolean ok = true;
      for (int i = 0; i < n; i++) {
        ok &= row[i] == a;
      }
      if (ok) {
        out.println("YES");
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            out.print(result[i][j]);
          }
          out.println();
        }
      } else {
        out.println("NO");
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
    try (ABMatrix instance = new ABMatrix()) {
      instance.solve();
    }
  }
}
