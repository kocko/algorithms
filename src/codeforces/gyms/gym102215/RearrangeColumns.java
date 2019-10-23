package codeforces.gyms.gym102215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RearrangeColumns implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[][] grid = new char[][] {in.next().toCharArray(), in.next().toCharArray()};
    int n = grid[0].length;
    List<Integer> one = new ArrayList<>();
    List<Integer> two = new ArrayList<>();
    List<Integer> three = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int mask = grid[0][i] == '#' ? 1 : 0;
      mask |= (grid[1][i] == '#') ? 2 : 0;
      if (mask == 1) {
        one.add(i);
      } else if (mask == 2) {
        two.add(i);
      } else if (mask == 3) {
        three.add(i);
      }
    }
    char[][] result = new char[2][n];
    int idx = 0;
    for (int next : one) {
      result[0][idx] = grid[0][next];
      result[1][idx] = grid[1][next];
      idx++;
    }
    for (int next : three) {
      result[0][idx] = grid[0][next];
      result[1][idx] = grid[1][next];
      idx++;
    }
    for (int next : two) {
      result[0][idx] = grid[0][next];
      result[1][idx] = grid[1][next];
      idx++;
    }
    while (idx < n) {
      result[0][idx] = result[1][idx] = '.';
      idx++;
    }
    if (one.size() > 0 && two.size() > 0 && three.size() == 0) {
      out.println("NO");
    } else {
      out.println("YES");
      for (int i = 0; i < 2; i++) {
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
    try (RearrangeColumns instance = new RearrangeColumns()) {
      instance.solve();
    }
  }
}
