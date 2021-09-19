package atcoder.beginner.contest212;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class QueryingMultiset implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public QueryingMultiset() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public QueryingMultiset(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    PriorityQueue<Long> queue = new PriorityQueue<>();
    long sum = 0;
    int q = in.ni();
    for (int i = 0; i < q; i++) {
      int type = in.ni();
      if (type == 1) {
        long next = in.nl();
        queue.add(next - sum);
      } else if (type == 2) {
        long delta = in.nl();
        sum += delta;
      } else {
        out.println(queue.poll() + sum);
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
    try (QueryingMultiset instance = new QueryingMultiset()) {
      instance.solve();
    }
  }
}
