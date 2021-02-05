package codeforces.contests1401_1500.problemset1481;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpaceNavigation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int x = in.ni(), y = in.ni();
      char[] instructions = in.next().toCharArray();
      char h, v;
      if (x < 0) {
        h = 'L';
      } else {
        h = 'R';
      }
      if (y < 0) {
        v = 'D';
      } else {
        v = 'U';
      }
      int hor = 0, ver = 0;
      for (char c : instructions) {
        if (c == h) {
          hor++;
        } else if (c == v) {
          ver++;
        }
      }
      boolean ok = hor >= Math.abs(x) && ver >= Math.abs(y);
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
    try (SpaceNavigation instance = new SpaceNavigation()) {
      instance.solve();
    }
  }
}
