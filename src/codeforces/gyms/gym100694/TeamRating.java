package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.max;
import static java.lang.Double.min;

public class TeamRating implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[][] rating = new int[n][2];
    for (int i = 0; i < n; i++) {
      rating[i][0] = in.ni();
      rating[i][1] = in.ni();
      if (rating[i][0] < rating[i][1]) {
        int temp = rating[i][0];
        rating[i][0] = rating[i][1];
        rating[i][1] = temp;
      }
    }
    boolean flag = false;
    double left = 0d, right = 1d, eps = 1e-9;
    int px = rating[0][0], py = rating[0][1];
    for (int i = 1; i < n; i++) {
      int x = rating[i][0], y = rating[i][1];
      int res = px - x + y - py;
      if (res > 0) {
        left = max(left, (y - py) * 1.0 / res);
      } else if (res < 0) {
        right = min(right, (y - py) * 1.0 / res);
      } else if (y - py > 0) {
        flag = true;
      }
      px = x;
      py = y;
    }
    out.println(flag || left > right + eps ? "NO" : "YES");
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
    try (TeamRating instance = new TeamRating()) {
      instance.solve();
    }
  }
}
