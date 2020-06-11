package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class BirthdayCake implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    points = new long[n + 1][2];
    for (int i = 1; i <= n; i++) {
      points[i][0] = in.nl();
      points[i][1] = in.nl();
    }
    //prefix[i] is "almost" the area of the polygon between [1...i],
    //but without the last summand (x[i] * y[0] - x[0] * y[i])
    long[] prefix = new long[n + 1];
    for (int i = 2; i <= n; i++) {
      prefix[i] = prefix[i - 1] + multiply(i - 1, i);
    }
    long total = prefix[n] + multiply(n, 1);
    long minDiff = Long.MAX_VALUE;
    int[] result = {0, 0};
    int u = 1, v = 2;
    //lets apply a two-pointer approach to find the "best" cut
    //between vertices u and v, such that the difference between
    //the two resulting parts is minimal
    while (u <= n && v <= n) {
      //increase the cut to the right until it exceeds half of the total area
      while (v <= n) {
        long cut = 2 * abs(prefix[v] - prefix[u] + multiply(v, u));
        if (cut > total) break;
        if (total - cut < minDiff) {
          minDiff = total - cut;
          result = new int[]{u, v};
        }
        v++;
      }

      //the cut now exceeds half of the area, but it could bring a minimal difference
      if (v <= n) {
        long cut = 2 * abs(prefix[v] - prefix[u] + multiply(v, u));
        if (cut - total < minDiff) {
          minDiff = cut - total;
          result = new int[]{u, v};
        }
      }
      v--;
      u++;
    }
    out.printf("%d %d\n", result[0], result[1]);
  }

  private long[][] points;

  private long multiply(int i, int j) {
    return points[i][0] * points[j][1] - points[i][1] * points[j][0];
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
    try (BirthdayCake instance = new BirthdayCake()) {
      instance.solve();
    }
  }
}
