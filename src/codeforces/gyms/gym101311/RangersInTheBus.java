package codeforces.gyms.gym101311;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RangersInTheBus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      result.add(new ArrayList<>());
    }
    final int red = 0, blue = 1, black = 2, yellow = 3, pink = 4;
    int[][] data = new int[k + 1][2];
    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < 2; j++) {
        data[i][j] = in.ni();
      }
    }
    Map<Integer, Integer> bus = new TreeMap<>();
    int firstRow = 1, lastRow = n;
    for (int i = 1; i <= k; i++) {
      int row = data[i][0], col = data[i][1];
      int firstRowInfo = bus.getOrDefault(firstRow, 0), lastRowInfo = bus.getOrDefault(lastRow, 0);
      if (row == firstRow) {
        if (firstRowInfo == 0) {
          if (col == 1) {
            result.get(red).add(i);
          } else if (col == 2) {
            result.get(blue).add(i);
          }
        } else if (firstRowInfo > 0) {
          result.get(red).add(i);
          result.get(blue).add(i);
        }
      }
      if (row == lastRow) {
        if (lastRowInfo == 0) {
          if (col == 1) {
            result.get(black).add(i);
          } else if (col == 2) {
            result.get(yellow).add(i);
          }
        } else if (lastRowInfo > 0) {
          result.get(black).add(i);
          result.get(yellow).add(i);
        }
      }
      result.get(pink).add(i);
      bus.put(row, bus.getOrDefault(row, 0) | col);
      while (bus.getOrDefault(firstRow, 0) == 3) {
        firstRow++;
      }
      while (bus.getOrDefault(lastRow, 0) == 3) {
        lastRow--;
      }
    }
    for (List<Integer> list : result) {
      out.print(list.size());
      out.print(' ');
      for (int value : list) {
        out.print(value);
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
    try (RangersInTheBus instance = new RangersInTheBus()) {
      instance.solve();
    }
  }
}
