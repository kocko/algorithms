package atcoder.beginner.contest176;

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

public class Bomber implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Bomber() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int R = in.ni(), C = in.ni(), m = in.ni();
    int[] rows = new int[R + 1];
    int[] cols = new int[C + 1];

    Map<Integer, Set<Integer>> bombs = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int row = in.ni(), col = in.ni();
      Set<Integer> set = bombs.getOrDefault(row, new HashSet<>());
      set.add(col);
      bombs.put(row, set);
      rows[row]++;
      cols[col]++;
    }
    int bestRow = 0;
    for (int row = 1; row <= R; row++) {
      if (rows[row] > rows[bestRow]) {
        bestRow = row;
      }
    }
    int bestCol = 0;
    for (int col = 1; col <= C; col++) {
      if (cols[col] > cols[bestCol]) {
        bestCol = col;
      }
    }
    List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
    for (int row = 1; row <= R; row++) {
      if (rows[row] == rows[bestRow]) {
        a.add(row);
      }
    }
    for (int col = 1; col <= C; col++) {
      if (cols[col] == cols[bestCol]) {
        b.add(col);
      }
    }
    int result = rows[bestRow] + cols[bestCol] - 1;
    out:
    for (int x : a) {
      Set<Integer> set = bombs.get(x);
      for (int y : b) {
        if (!set.contains(y)) {
          result = rows[bestRow] + cols[bestCol];
          break out;
        }
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
    try (Bomber instance = new Bomber()) {
      instance.solve();
    }
  }
}
