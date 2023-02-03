package codeforces.contests1701_1800.problemset1791;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FollowingDirections implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public FollowingDirections() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    Map<Character, int[]> DIFF = Map.of(
        'U', new int[]{0, 1},
        'D', new int[]{0, -1},
        'L', new int[]{-1, 0},
        'R', new int[]{1, 0});
    while (T-- > 0) {
      int n = in.ni();
      char[] a = in.next().toCharArray();
      int x = 0, y = 0;
      boolean ok = false;
      for (char c : a) {
        int[] dir = DIFF.get(c);
        x += dir[0];
        y += dir[1];
        ok |= (x == 1 && y == 1);
      }
      out.println(ok ? "YES" : "NO");
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
    try (FollowingDirections instance = new FollowingDirections()) {
      instance.solve();
    }
  }
}
