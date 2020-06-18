package codeforces.contests1301_1400.problemset1368;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CodeforcesSubsequences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final char[] cf = "codeforces".toCharArray();
    long k = in.nl();
    PriorityQueue<Long> queue = new PriorityQueue<>();
    for (int i = 0; i < 10; i++) {
      queue.add(1L);
    }
    long product = 1;
    while (product < k) {
      long min = queue.poll();
      product /= min;
      product *= (min + 1);
      queue.add(min + 1);
    }
    int idx = 0;
    while (queue.size() > 0) {
      long times = queue.poll();
      for (int i = 0; i < times; i++) {
        out.print(cf[idx]);
      }
      idx++;
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
    try (CodeforcesSubsequences instance = new CodeforcesSubsequences()) {
      instance.solve();
    }
  }
}
