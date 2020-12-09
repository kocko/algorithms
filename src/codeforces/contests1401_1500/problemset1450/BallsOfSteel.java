package codeforces.contests1401_1500.problemset1450;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class BallsOfSteel implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int k = in.ni();
      int[][] points = new int[n][2];
      for (int i = 0; i < n; i++) {
        points[i][0] = in.ni();
        points[i][1] = in.ni();
      }

      int result = -1;
      for (int i = 0; i < n; i++) {
        boolean reachable = true;
        for (int j = 0; j < n; j++) {
          if (abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]) > k) {
            reachable = false;
            break;
          }
        }
        if (reachable) {
          result = 1;
          break;
        }
      }
      out.println(result);
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
    try (BallsOfSteel instance = new BallsOfSteel()) {
      instance.solve();
    }
  }
}
