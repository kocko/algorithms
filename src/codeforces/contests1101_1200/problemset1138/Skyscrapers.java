package codeforces.contests1101_1200.problemset1138;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Skyscrapers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    int[][] grid = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = in.ni();
      }
    }
    int[][] rows = new int[n][m];
    int[] sizeByRow = new int[n];
    for (int i = 0; i < n; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        row.add(grid[i][j]);
      }
      row.sort(Comparator.naturalOrder());
      Map<Integer, Integer> order = new HashMap<>();
      int idx = 1;
      order.put(row.get(0), 1);
      for (int j = 1; j < m; j++) {
        if (!row.get(j).equals(row.get(j - 1))) {
          order.put(row.get(j), ++idx);
        }
      }
      for (int j = 0; j < m; j++) {
        rows[i][j] = order.get(grid[i][j]);
      }
      sizeByRow[i] = idx;
    }

    int[][] cols = new int[n][m];
    int[] sizeByCol = new int[m];
    for (int j = 0; j < m; j++) {
      List<Integer> col = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        col.add(grid[i][j]);
      }
      col.sort(Comparator.naturalOrder());
      Map<Integer, Integer> order = new HashMap<>();
      int idx = 1;
      order.put(col.get(0), 1);
      for (int i = 1; i < n; i++) {
        if (!col.get(i).equals(col.get(i - 1))) {
          order.put(col.get(i), ++idx);
        }
      }
      for (int i = 0; i < n; i++) {
        cols[i][j] = order.get(grid[i][j]);
      }
      sizeByCol[j] = idx;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int o1 = rows[i][j], o2 = cols[i][j];
        int a, b, offset;
        if (o1 >= o2) {
          offset = o1 - o2;
          a = sizeByRow[i];
          b = sizeByCol[j] + offset;
        } else {
          offset = o2 - o1;
          a = sizeByRow[i] + offset;
          b = sizeByCol[j];
        }
        out.print(Math.max(a, b));
        out.print(' ');
      }
      out.println();
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
    try (Skyscrapers instance = new Skyscrapers()) {
      instance.solve();
    }
  }
}
