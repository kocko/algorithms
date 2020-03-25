package codeforces.contests1301_1400.problemset1315;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Recommendations implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[][] x = new int[n][2];
    for (int i = 0; i < n; i++) {
      x[i][0] = in.ni();
    }
    for (int i = 0; i < n; i++) {
      x[i][1] = in.ni();
    }
    Arrays.sort(x, Comparator.comparingInt(t -> t[0]));
    long result = 0;
    long sum = 0;
    int last = 0;

    PriorityQueue<Integer> queue = new PriorityQueue<>((p1, p2) -> p2 - p1);
    for (int idx = 0; idx < n; idx++) {
      int point = x[idx][0];
      while ((last + 1) < point && queue.size() > 0) {
        sum -= queue.poll();
        result += sum;
        last++;
      }
      last = x[idx][0];

      sum += x[idx][1];
      queue.add(x[idx][1]);
      if ((idx + 1) < n && x[idx][0] != x[idx + 1][0]) {
        sum -= queue.poll();
        result += sum;
      }
    }
    while (queue.size() > 0) {
      sum -= queue.poll();
      result += sum;
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
    try (Recommendations instance = new Recommendations()) {
      instance.solve();
    }
  }
}
