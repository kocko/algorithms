package codeforces.contests1201_1300.problemset1296;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class YetAnotherWalkingRobot implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] path = in.next().toCharArray();
      Map<Pair, Integer> map = new HashMap<>();
      int x = 0, y = 0;
      map.put(new Pair(0, 0), 0);
      int start = -1, end = n + 2;
      for (int i = 1; i <= n; i++) {
        char ch = path[i - 1];
        if (ch == 'L') x--;
        else if (ch == 'R') x++;
        else if (ch == 'D') y--;
        else y++;

        Pair match = new Pair(x, y);
        if (map.containsKey(match)) {
          int where = map.get(match);
          if (i - where < end - start) {
            start = where + 1;
            end = i;
          }
        }
        map.put(new Pair(x, y), i);
      }
      if (start == -1) {
        out.println(-1);
      } else {
        out.println(start + " " + end);
      }
    }
  }

  private class Pair {
    private int x, y;

    private Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
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
    try (YetAnotherWalkingRobot instance = new YetAnotherWalkingRobot()) {
      instance.solve();
    }
  }
}
