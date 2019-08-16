package codeforces.gyms.gym102277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircleMeetsSquare implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int x = in.ni(), y = in.ni(), r = in.ni();
    int tx = in.ni(), ty = in.ni(), s = in.ni();
    int[][] points = new int[4][2];
    points[0] = new int[]{tx, ty};
    points[1] = new int[]{tx, ty + s};
    points[2] = new int[]{tx + s, ty};
    points[3] = new int[]{tx + s, ty + s};
    int inside = 0, touch = 0;
    for (int[] point : points) {
      int dist = (point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y);
      if (dist < r * r) {
        inside++;
      } else if (dist == r * r) {
        touch++;
      }
    }
    if (inside > 0) {
      out.println(2);
    } else {
      if (touch >= 2) {
        out.println(2);
      } else if (touch == 1) {
        out.println(1);
      } else {
        out.println(0);
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
    try (CircleMeetsSquare instance = new CircleMeetsSquare()) {
      instance.solve();
    }
  }
}
