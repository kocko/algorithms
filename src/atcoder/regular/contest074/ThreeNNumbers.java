package atcoder.regular.contest074;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ThreeNNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] x = new long[3 * n];
    for (int i = 0; i < 3 * n; i++) {
      x[i] = in.nl();
    }
    PriorityQueue<Long> queue = new PriorityQueue<>();
    long[] max = new long[3 * n];
    long sum = 0;
    for (int i = 0; i < 3 * n; i++) {
      queue.add(x[i]);
      sum += x[i];
      if (queue.size() > n) {
        sum -= queue.poll();
      }
      max[i] = sum;
    }
    queue = new PriorityQueue<>(Comparator.reverseOrder());
    sum = 0;
    long[] min = new long[3 * n];
    for (int i = 3 * n - 1; i >= 0; i--) {
      queue.add(x[i]);
      sum += x[i];
      if (queue.size() > n) {
        sum -= queue.poll();
      }
      min[i] = sum;
    }
    long result = Long.MIN_VALUE;
    for (int i = n - 1; i < 2 * n; i++) {
      result = Math.max(max[i] - min[i + 1], result);
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
    try (ThreeNNumbers instance = new ThreeNNumbers()) {
      instance.solve();
    }
  }
}
