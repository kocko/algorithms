package codeforces.gyms.gym102152;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArrayNegations implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      int sum = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        sum += next;
        queue.add(next);
      }
      while (k-- > 0) {
        int smallest = queue.poll();
        sum -= 2 * smallest;
        queue.add(-smallest);
      }
      out.println(sum);
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
    try (ArrayNegations instance = new ArrayNegations()) {
      instance.solve();
    }
  }
}
