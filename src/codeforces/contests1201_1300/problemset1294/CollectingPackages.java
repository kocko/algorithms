package codeforces.contests1201_1300.problemset1294;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CollectingPackages implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Robot implements Comparable<Robot> {
    private int x, y;

    private Robot(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Robot robot) {
      int x = Integer.compare(this.x, robot.x);
      int y = Integer.compare(this.y, robot.y);
      return x != 0 ? x : y;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      List<Robot> robots = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        robots.add(new Robot(in.ni(), in.ni()));
      }
      robots.sort(Comparator.naturalOrder());
      solve(robots);
    }
  }

  private void solve(List<Robot> robots) {
    StringBuilder result = new StringBuilder();
    int x = 0, y = 0;
    for (Robot robot : robots) {
      if (x > robot.x || y > robot.y) {
        out.println("NO");
        return;
      }
      if (x < robot.x) {
        int dist = robot.x - x;
        for (int i = 0; i < dist; i++) {
          result.append('R');
        }
      }
      if (y < robot.y) {
        int dist = robot.y - y;
        for (int i = 0; i < dist; i++) {
          result.append('U');
        }
      }
      x = robot.x;
      y = robot.y;
    }
    out.println("YES");
    out.println(result.toString());
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
    try (CollectingPackages instance = new CollectingPackages()) {
      instance.solve();
    }
  }
}
