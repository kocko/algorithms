package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheLostGraph implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    List<int[]> graph = new ArrayList<>();
    for (int i = 0; i < 2 * n; i++) {
      String operation = in.next();
      int vertex = in.ni();
      if ("in".equals(operation)) {
        deque.offerLast(vertex);
      } else {
        deque.pollLast();
        if (deque.size() > 0) {
          graph.add(new int[]{vertex, deque.peekLast()});
        }
      }
    }
    for (int[] edge : graph) {
      out.println(edge[0] + " " + edge[1]);
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
    try (TheLostGraph instance = new TheLostGraph()) {
      instance.solve();
    }
  }
}
